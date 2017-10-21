<%-- 
    Document   : index
    Created on : 01/10/2017, 16:18:12
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
               position: absolute;
                top: 2em;
                left: 35em;
                width: 9em
            }
            p{
                position: absolute;
                left: 4em;
                top : 0em;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Adiciona Contato -->
         <%  int id = 1;
            for(Pessoa p:dao.findAll()){ 
                id++;
            }
        %>           
        <table border="1" >
             <tr>
                <td>
                    <p><%=id%></p><br>
                    <form action="CadastroServ" method="post">
                        <br><input type="hidden" name="id" value="<%=id%>"/>
                        Nome:
                        <br/><input type="text" name="nome"/><br/>
                        Telefone:
                        <br/><input type="text" name="telefone"/><br/>
                        Email:
                        <br/><input type="text" name="email"/><br/>
                        <br/><input type="submit" value="Adicionar" name="btn"/><br/>
                    </form>
                </td>
            </tr>
        </table>            
    </body>
</html>