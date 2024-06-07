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
			<link rel="stylesheet" type="text/css" href="carrossel.css">
			<link rel="stylesheet" type="text/css" href="cadastro.css">
		
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

<div class="cadastro">
 <div class="form_cadastro_filho">
 	<div class="form_cadastro_filho1">
 	<p class="nome_cadastro">Cadastro</p>
	<form action="cadastro" method="post">
			<tag for="cpf">Cpf:</tag><br><input class="input_cpf" name="cpf" type="text" required><br>
			<tag for="nome">Nome completo: </tag><br><input class="input_senha" name="nome" type="text" required><br>
			<tag for="email">Email: </tag><br><input class="input_senha" name="email" type="email" required><br>
			<tag for="cep">Cep: </tag><br><input class="input_cep" name="cep" type="text" required><br>
			<tag for="endereco">Endereço:</tag><br><input class="input_endereco" name="endereco" type="text" required><br>
			<tag for="tel">Telefone com ddd: </tag><br><input class="input_tel" name="tel" type="tel" required><br>
			<tag for="senha">Senha:</tag><br><input class="input_senha" name="senha" type="password" placeholder="mínimo de 8 dígitos Letras e Números" pattern="[0-9A-Za-Z]{8,}" required><br>
			<button type="submit" class="botao_form">Cadastrar</button>
	</form>
	</div>
</div>
</div>




	 
		
		<footer>
			<div class="rodappe">
					<div>
						<h2>Sobre Nós</h2>
						<ul>
							<li>Quem Somos</li>
							<li>Serviços</li>
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
			<script type="text/javascript"  src="cadastro.js"></script>
				
</body>
</html>