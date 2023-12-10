package senac.java.Controllers;

import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import senac.java.Domain.Agendamentos;
import senac.java.Services.ResponseEndPoints;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
public class AgendamentoController {
    public static List<Agendamentos> usersList = new ArrayList<>();

    public static class UserHandler implements HttpHandler{
        static ResponseEndPoints res = new ResponseEndPoints();

        @Override
        public void handle(HttpExchange exchange) throws IOException{
            String response = "";
            if("GET".equals(exchange.getRequestMethod())){

                response = "Essa é a rota de usuario - GET";
                res. enviarResponse(exchange, response,200);
                usersList.reversed();




            }else if ("POST".equals(exchange.getRequestMethod())) {

                try (InputStream requestBody = exchange.getRequestBody()) {
                    JSONObject json = new JSONObject(new String(requestBody.readAllBytes()));

                    Agendamentos user = new Agendamentos(

                            json.getString("name"),
                            json.getString("lastName"),
                            json.getString("cpf"),
                            json.getString("email"),
                            json.getString("horario"),
                            json.getString("pelagem"),
                            json.getString("especie"),
                            json.getString("raca")


                    );
                    usersList.add(user);
                    user.toJson();
                    response = "Dados enviados com sucesso";
//                    res.enviarResponse(exchange, response, 201);
                    res.enviarResponseJson(exchange, user.toJson(),200);


                } catch (Exception e) {
                    String resposta = e.toString();
                    res.enviarResponse(exchange, resposta, 200);

                }
//                res. enviarResponse(exchange, response);
//                response = "Essa é a rota de usuario - POST";
            } else if ("PUT".equals(exchange.getRequestMethod())) {
                res. enviarResponse(exchange, response,200);
                response = "Essa e a rota de usuario - PUT";
            } else if ("DELETE".equals(exchange.getRequestMethod())) {
                res. enviarResponse(exchange, response,200);
                response = "Essa e a rota de usuario - DELETE";
            }else {
                response = "Rota usuario - ERRO!" +
                        " O metodo utilizado foi: " + exchange.getRequestMethod();;
                res. enviarResponse(exchange, response,200);
            }
        }}}