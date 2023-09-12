<%@ page import="br.com.kennedy.domain.entities.Account" %>
<%@ page import="br.com.kennedy.domain.services.AccountOperations" %>
<%@ page import="br.com.kennedy.utils.ServiceLocator" %>
<%@ page import="br.com.kennedy.domain.entities.TypeOperation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<main class="container-fluid full min-vh-100 d-flex flex-column justify-content-center align-items-center gap-2 bg-body-secondary">
    <span class=" container bg-primary rounded d-flex align-items-center justify-content-center py-2 w-100">
             <h1 class="align-self-center text-light">Caixa eletrônico</h1>
    </span>
    <section class="container d-flex flex-column bg-light-subtle rounded p-5">
        <div class="d-flex flex-column align-items-center">
            <h2 class="fs-1 text-primary fw-bold">Saldo</h2>
            <p class="fs-3">R$ <%= request.getParameter("balance") %>
            </p>
        </div>
        <form action="/" method="post">
            <div class="row mb-3">
                <div class="col-12">
                    <div class="form-floating">
                        <input id="value" required type="text" class="form-control" name="value"/>
                        <label for="value">Valor (R$)</label>
                    </div>
                </div>
            </div>
            <button class="btn btn-primary" name="<%=TypeOperation.DEPOSIT.getValue()%>" type="submit">Depositar</button>
            <button class="btn btn-primary" type="submit" name="<%=TypeOperation.WITHDRAWAL.getValue()%>">Sacar</button>
        </form>
        <%
            if (Boolean.parseBoolean(request.getParameter("error"))) {
                out.println("<p class='text-danger'>Operação cancelada! Saldo não pode ser negativo!</p>");
            }
        %>
    </section>
</main>
</body>
</html>
