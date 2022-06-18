package edu.uepb.web.biblioteca.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import edu.uepb.web.biblioteca.dao.AlunoDAOImpl;
import edu.uepb.web.biblioteca.dao.DividaDAOImpl;
import edu.uepb.web.biblioteca.dao.EmprestimoDAOImpl;
import edu.uepb.web.biblioteca.dao.ReservaDAOImpl;
import edu.uepb.web.biblioteca.dao.UniversidadeDAOImpl;
import edu.uepb.web.biblioteca.enums.TipoFuncionario;
import edu.uepb.web.biblioteca.exception.AutenticacaoException;
import edu.uepb.web.biblioteca.exception.EmprestimoException;
import edu.uepb.web.biblioteca.exception.ExistException;
import edu.uepb.web.biblioteca.model.Aluno;
import edu.uepb.web.biblioteca.model.Funcionario;
import edu.uepb.web.biblioteca.model.Universidade;

/**
 * Classe Service do Aluno
 *
 * @autor geovanniovinhas <vinhasgeovannio@gmail.com
 */
@Service
public class AlunoService {
	private static Logger logger = Logger.getLogger(AlunoService.class);
	private AlunoDAOImpl alunoDAO = new AlunoDAOImpl();
	private DividaDAOImpl dividaDAO;
	private EmprestimoDAOImpl emprestimoDAO;
	private ReservaDAOImpl reservaDAO;
	private UniversidadeDAOImpl universidadeDAO = new UniversidadeDAOImpl();
	private CursoService cursoService;

	/**
	 * Autenticar aluno
	 *
	 * @param matricula
	 * @param senha
	 * @return Aluno
	 * @throws AutenticacaoException
	 */
	public Aluno autenticar(String matricula, String senha) throws AutenticacaoException {
		logger.info("Executa o metodo 'autenticar' do alunoService");
		return alunoDAO.login(matricula, senha);
	}

	/**
	 *
	 * Cadastrar aluno. Qualquer funcion rio poder  cadastrar o aluno.
	 *
	 * @param funcionario
	 * @param aluno
	 * @return id do aluno cadastrado
	 * @throws AutenticacaoException
	 * @throws ExistException
	 */
	public int cadastrarAluno(Funcionario funcionario, Aluno aluno) throws AutenticacaoException, ExistException {
		logger.info("Executa o metodo 'cadastrarAluno' do alunoService com param: " + funcionario + " e : " + aluno);

		Universidade universidade = universidadeDAO.get();
		aluno.setPeriodoIngresso(universidade.getPeriodo());
		aluno.setMatricula(this.gerarMatricula(aluno));
		if (alunoDAO.isExiste(aluno)) {
			logger.error("Ja existe aluno com esta matricula, matricula: " + aluno.getMatricula());
			throw new ExistException("O aluno ja cadastrado no sistema");
		}
		logger.info("O Aluno cadastrado com sucesso: " + aluno);
		return alunoDAO.inserir(aluno);
	}

	/**
	 * Gera matricula para o aluno cadastrado. A matricula e unico para cada aluno.
	 *
	 * @param aluno
	 * @return matricula gerado
	 */
	public String gerarMatricula(Aluno aluno){

		return cursoService.criarAbreviacaoTipoNivel(aluno) + cursoService.criaAbreviacaoNomeCurso(aluno)+
				criarAbreviacaoAnoIngresso(aluno) + criarCodigo(aluno);
	}
	public String criarAbreviacaoAnoIngresso(Aluno aluno){
		String ano , anoAbreviacao;
		ano = aluno.getAno();
		anoAbreviacao = ano.substring(2, ano.length());
		return anoAbreviacao;
	}
	public String criarCodigo(Aluno aluno){
		String codigo;
		codigo = String.format("%03d", alunoDAO.getUltimoId() + 1);
		return codigo;
	}

	/**
	 *
	 * Remover aluno. S  o funcion rio do tipo administrador poder  remover.
	 *
	 * @param funcionario
	 * @param aluno
	 * @return true se foi removido
	 * @throws AutenticacaoException
	 * @throws EmprestimoException
	 */
	public void removerAluno(Funcionario funcionario, Aluno aluno) throws AutenticacaoException, EmprestimoException {
		logger.info("Executa o metodo 'removerAluno' do alunoBusiness: " + funcionario + " e aluno: " + aluno);
		if (!funcionario.getTipoFunc().equals(TipoFuncionario.ADMINISTRADOR)) {
			logger.error("Funcionario nao autorizado, idFuncionario: " + funcionario.getId());
			throw new AutenticacaoException("Este funcionario nao esta autorizado");
		} else {
			alunoDAO = new AlunoDAOImpl();
			dividaDAO = new DividaDAOImpl();
			reservaDAO = new ReservaDAOImpl();

			if (dividaDAO.isAlunoTemDivida(aluno.getId())) {
				logger.error("O aluno ainda tem divida " + aluno.getId());
				throw new EmprestimoException("Nao pode remover o aluno, ele ainda tem divida");
			}
			emprestimoDAO = new EmprestimoDAOImpl();

			if (emprestimoDAO.getEmprestimoAtivoDoAluno(aluno.getId()) != null) {
				logger.error("O aluno ainda tem item emprestado " + aluno.getId());
				throw new EmprestimoException("Nao pode remover o aluno, ele tem emprestimo registrado");
			}

			// remover as suas dividas registradas
			dividaDAO.removerDividasAluno(aluno.getId());

			// remover os seus remprestimos registrados
			emprestimoDAO.removerEmprestimoAluno(aluno.getId());

			// remover as suas reservas registradas
			reservaDAO.removerReservasAluno(aluno.getId());

			alunoDAO.remover(aluno);
			logger.info("O Aluno removido com sucesso: " + aluno);
		}
	}

	/**
	 * Atualizar dados do aluno. Qualquer funcion rio poder  atualizar.
	 * @param aluno
	 * @return boolean
	 */
	public boolean atualizarAluno(Aluno aluno) {
		logger.info("Executa o metodo 'atualizarAluno' alunoBusiness: " + aluno);

		alunoDAO = new AlunoDAOImpl();
		alunoDAO.atualizar(aluno);
		logger.info("O Aluno atualizado com sucesso: " + aluno);
		return true;
	}

	/**
	 * Pegar os alunos do sistema
	 *
	 * @return List<Aluno>
	 */
	public List<Aluno> getListaAluno() {
		logger.info("Executa o metodo 'getListaAluno' do AlunoService");
		alunoDAO = new AlunoDAOImpl();
		return alunoDAO.getLista();
	}

	/**
	 * Pegar o Aluno pelo seu ID
	 *
	 * @param idAluno
	 * @return Aluno
	 */
	public Aluno getAlunoById(int idAluno) {
		logger.info("Executa o metodo 'getAlunoById' do AlunoService :" + idAluno);
		alunoDAO = new AlunoDAOImpl();
		return alunoDAO.getById(idAluno);
	}

}
