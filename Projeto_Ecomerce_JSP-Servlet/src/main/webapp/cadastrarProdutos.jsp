<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map" %>
<%@ page import="dao.Valor_barramenu" %>
<%@ page import="service.ProductRepository" %>
<%@ page import="dao.Products" %>
<%@ page import="java.util.List" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
			<meta charset="ISO-8859-1">
			<title>Home</title>
			<link rel="stylesheet" type="text/css" href="home.css">
			<link rel="stylesheet" type="text/css" href="cadastarProdutos.css">
		
</head>
<body>
<div class="central">
		<div class="pai_headerBar">
			<div class="filho_headerBar01">
					<div class="logo">
							<img src="imagens/logo.png" class="img_logo">
										
					</div>
					<div class="searchBar">
					<div id="divBusca" >
    					<form action="busca" class="form" method="get">
  							<input type="text" id="txtBusca" name="nome" placeholder="Buscar..."/>
  							<button id="btnBusca" type="submit">Buscar</button>
  						</form>	
  					</div> 		
					</div>
					<div class="infoBar">
						<% HttpSession session=request.getSession(false);
						    if(session!=null){
							    String nome=session.getAttribute("nome").toString();
					   %>
							<p>Bem Vindo, <%=nome%></p>
					   <%
						   }
					   %>
							<a href="login"><img src="imagens/iconlogin.png" alt="Buscar..." class="iconlogin"/></a>
						    <a href=""><img src="imagens/shoppingcart.png" alt="Buscar..." class="iconCart"/></a>
						    <a href=""><img src="imagens/iconcell.png" alt="Buscar..." class="iconcell"/></a>
					</div>
			</div>
			
			<div class="filho_headerBar02">
					<nav class="navbar">
							<div class="menu"><div class="menu_inicio"><img src="imagens/iconmenu.png" alt="Buscar..." class="iconmenu"/>
									<p>Todos os Departamentos</p></div>
									<div class="dropdown">
											<ul>
													<%
								             			Map<String,String> drop=new Valor_barramenu().getDrop();
											    		for (Map.Entry<String, String> entry : drop.entrySet()) {
											 	%>
											 		<li><a class="dropdown-content" href="<%=entry.getValue()%>"><%=entry.getKey()%></a></li>
											    	
												<%    	
											    		}
												%>
											    	

											</ul>
							
									</div>
							
							
							</div>
							
								             <%
								             	Map<String,String> menu=new Valor_barramenu().getMenu();
											    for (Map.Entry<String, String> entry : menu.entrySet()) {
											 %>
											 		<div class="opcao"><a class="links_menu" href="<%=entry.getValue()%>"><p><%=entry.getKey()%></p></a></div>
											    	
											<%    	
											    }
											%>
					</nav>

			</div>
		</div>

<div class="form_cadastro">
 <div class="form_cadastro_filho">
 	<p class="nome_cadastro">Cadastro De Produtos</p>
 	<div class="formulario">
	 	<form action="cadastrarprodutos" method="post">
	 	  <fieldset>
				<tag for="">Nome Produto: </tag><input class="nome" name="nome" type="text" required><br>
				<tag for="">Descri��o: </tag><input class="descricao" name="descricao" type="text" required><br>
				<tag for="categoria">Categoria:</label>
	  				<select id="categoria" name="categoria">
	    					<option value="Eletro">Eletro</option>
	    					<option value="SmartPhone">SmartPhone</option>
	    					<option value="Televisor">Televisor</option>
	    					<option value="Informatica">Informatica</option>
	  				</select>
				<tag for="">Quantidade: </tag><input class="quantida" name="quantidade" type="number" required><br>
				<tag for="">Url_img: </tag><input class="url" name="url" type="text" required><br>
				<tag for="">Fabricante: </tag><input class="fabricante" name="fabricante" type="text" required><br>
				<tag for="">Valor de Compra: </tag><input class="vcompra" name="vcomnpra" type="number" required>
				<tag for="">Valor de Venda: </tag><input class="vvenda" name="vvenda" type="number" required><br>
				<button type="submit" class="botao_form">Cadastrar</button>
			  </fieldset>
		</form>
	</div>
	</div>


</div>




	 
		
		<footer>
			<div class="rodappe">
					<div>
						<h2>Sobre N�s</h2>
						<ul>
							<li>Quem Somos</li>
							<li>Servi�os</li>
							<li>Trabalhe Conosco</li>
							<li>Encontre um Loja</li>
						</ul>
					</div>

					<div>
							<h3>AJUDA</h3>
						<ul>
							<li>Mapa do Site</li>
							<li>Prazos e Locais de Entrega</li>
							<li>Politica de Troca</li>
							<li>Politica de Privacidade</li>
						</ul>
					</div>
			
			
			
			</div>
		
		
		
		</footer>
			

</div>
			
				
</body>
</html>