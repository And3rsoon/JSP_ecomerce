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
		
		
		<div class="body_pai">
			<div class="carrossel" id="carrosselid">
			        <div class="voltar"><button class="btncarrossel" onClick="voltar()">&#10229</button></div>
			        <div class="seguir"><button class="btncarrossel" onClick="next()">&#10230</button></div>
            		<div class="quadro" id="quuadro">
            			<%
            					List<Products> produtos=new ProductRepository().ListarTodos();
								for (Products produtoss : produtos) {
						%>
								<a href="verprodutos?codigo=<%=produtoss.getCodigo().toString()%>" id="link"><div class="filho"><img src="<%=produtoss.getUrl_img()%>" style="width:200px;height:200px;"><p class="nomeProdCarrosseu"><%=produtoss.getNome()%></p><p class="precoProdCarrosseu">R$ <%=(Float.toString(produtoss.getValor_venda()).replace(".",","))%></h3><p>Em até 10x sem juros!</div></a>
						
											    	
						<%    	
								}
						%>
            		</div>
      		 </div> 
		</div>
		<h1>Ofertas</h1>
		<div class="cards_pai">
		
		 <div class="cards">
      		 		<a href="" class="link_car"><img src="https://blogdoiphone.com/wp-content/uploads/2022/11/iPhone-14-e-iPhone-14-Plus-Grande-e-Grandao-2.jpg" class="card_filho"></a>
	                <a href="" class="link_car"><img src="https://img.global.news.samsung.com/br/wp-content/uploads/2022/07/GalaxyM13_beneficios_KV.png" class="card_filho"></a>
	                <a href="" class="link_car"><img src="https://marcaspelomundo.com.br/wp-content/uploads/2021/04/Pedro-Sampaio-e-Malia-embalam-musica-campanha-dos-novos-smartphones-Galaxy-A.png" class="card_filho"></a>
	                <a href="" class="link_car"><img src="https://img.global.news.samsung.com/br/wp-content/uploads/2022/02/SamsungS22_KV5.png" class="card_filho"></a>
	                <a href="" class="link_car"><img src="https://www.minhaoperadora.com.br/wp-content/uploads/2021/07/Samsung-cria-marketing-com-%E2%80%98fofoca-de-fas-da-Apple.jpg" class="card_filho"></a>
	                <a href="" class="link_car"><img src="https://blogdoiphone.com/wp-content/uploads/2022/11/iPhone-14-e-iPhone-14-Plus-Grande-e-Grandao-2.jpg" class="card_filho"></a>
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
		<script type="text/javascript"  src="carrossel.js"></script>
				
</body>
</html>