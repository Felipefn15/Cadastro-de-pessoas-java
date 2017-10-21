<%-- 
    Document   : exibePessoas
    Created on : 07/10/2017, 09:52:45
    Author     : Felipe
--%>

<%@page import="uezo.Pessoa"%>
<%@page import="uezo.PessoaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%PessoaDAO dao = new PessoaDAO();%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            table{
               position: relative;
                left: 32em;
                width: 9em
            }
            p{
                position: relative;
                left: 37em;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <br/><p><a href="AdicionaPessoa.jsp">Novo Contato</a></p>
        <hr>
          <%
            for(Pessoa pes:dao.findAll()){
        %>
        <table border="1" >
            <tr>
            <td>Nome:<%=pes.getNome()%></td>
            </tr>
            <tr>
            <td >Telefone:<%=pes.getTelefone()%></td>
            </tr>
            <tr>
            <td >Email:<%=pes.getEmail()%></td>
            </tr>
            <tr>
                <td>ID:<%=pes.getId()%></td>
            </tr>
            <tr>
                
                <td><a href="CadastroServ?idEx=<%=pes.getId()%>&btn=Excluir"><input type="button" value="Excluir" name="btn"/></a></td>
            </tr>
            <tr>
                <td><a href="EditaPessoa.jsp?idEd=<%=pes.getId()%>&btn=Edita"><input type="button" value="Edita" name="btn"/></a></td>
            </tr>
            <br/>
            <%}%>
        </table>
        
    </body>
</html>

