        <%@page import="uezo.PessoaDAO"%>
        <%@page import="uezo.Pessoa"%>
<%-- 
    Document   : ExcluiPessoa
    Created on : 07/10/2017, 10:44:46
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%PessoaDAO dao = new PessoaDAO();%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            table{
               position: absolute;
                top: 2em;
                left: 35em;
                width: 9em
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Pessoa p = dao.findById(Integer.parseInt(request.getParameter("idEd")));
        %>
        <table border="1" >
             <tr>
                <td>
        
                    <form action="CadastroServ" method="post">
                        Id:
                        <br/><%=p.getId()%><input type="hidden" name="idEdita" value="<%=p.getId()%>"/><br/>           
                        Nome:
                        <br/><input type="text" name="nomeEdita" value="<%=p.getNome()%>"/><br/>
                        Telefone:
                        <br/><input type="text" name="telefoneEdita" value="<%=p.getTelefone()%>"/><br/>
                        Email:
                        <br/><input type="text" name="emailEdita" value="<%=p.getEmail()%>"/><br/>
                        <br/><input type="submit" value="Editar" name="btn"/><br/>
                    </form>
                </td>
            </tr>
        </table>    
    </body>
</html>