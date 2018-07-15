package instanciacao;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;

@WebServlet("/Instanciacao")
public class instaciacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Filme f1 = new Filme(null, "O aviador", 170, 2005);
			Filme f2 = new Filme(null, "Titanic", 195, 1997);

			Artista a1 = new Artista(null, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.00"),
					sdf.parse("11/11/1974"));
			Artista a2 = new Artista(null, "Cate Blanchett", "EUA", new BigDecimal("50000000.00"),
					sdf.parse("14/11/1374"));
			Artista a3 = new Artista(null, "Leonardo Di Caprio", "EUA", new BigDecimal("150000000.00"),
					sdf.parse("12/11/1874"));
			
			Participacao p1 = new Participacao(null, "Jack Dawson", new BigDecimal("2000000.00"), f2, a1);
			Participacao p2 = new Participacao(null, "Howard Hughes", new BigDecimal("1000000.00"), f1, a1);
			Participacao p3 = new Participacao(null, "Rose", new BigDecimal("1000000.00"), f2, a3);
			Participacao p4 = new Participacao(null, "Hepburn", new BigDecimal("5000000.00"), f1, a2);
			
			response.getWriter().append("Cache do filme:  "+f1+"\n");
			response.getWriter().append(f1.cacheTotal() +"\n");
			
			
			
			response.getWriter().append("Pronto ");

		} catch (ParseException e) {
			response.getWriter().append("Erro ao instaciar data. instacia nao criada ");
		}
		
	}

}
