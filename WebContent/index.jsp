<%@page import="com.ws.model.acessobd.EmpresaBanco"
		import="com.ws.model.acessobd.UsuarioBanco"
		import="com.ws.model.acessobd.ProtocoloBanco" 
		import="com.ws.model.acessobd.EmpresaProtocoloBanco"%> 
<html> 
<body> 

<% 

EmpresaBanco empresaBanco = new EmpresaBanco(); 
empresaBanco.retornarDados("teste"); 
empresaBanco.retornarDados();
empresaBanco.fecharFactory();

UsuarioBanco usuarioBanco = new UsuarioBanco(); 
usuarioBanco.retornarDados("teste");
usuarioBanco.retornarDados();
usuarioBanco.fecharFactory();
%> 

</body> 
</html>