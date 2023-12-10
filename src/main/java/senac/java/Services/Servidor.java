package senac.java.Services;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import senac.java.Controllers.EstoqueController;
import senac.java.Controllers.AgendamentoController;

import java.net.InetSocketAddress;
import java.io.IOException;
import com.sun.net.httpserver.HttpServer;

public class Servidor {

    public void apiServer() throws IOException{

        HttpServer server = HttpServer.create(new InetSocketAddress(4000),
                0);

        HttpHandler userHandler = new AgendamentoController.UserHandler();
        HttpHandler estoqueHandler = new EstoqueController.EstoqueHandler();




        server.createContext("/api/user", exchange -> {
            configureCorsHeads(exchange);
            userHandler.handle(exchange);

                });
        server.createContext("/api/estoque", exchange -> {
            configureCorsHeads(exchange);
            System.out.println("Teste  rota EStoque");
            estoqueHandler.handle(exchange);

                });




        server.setExecutor(null);
        server.start();
        System.out.println("Servidor iniciado;");
    }
    private void configureCorsHeads(HttpExchange exchange){
        Headers headers = exchange.getResponseHeaders();
        String requestOrigin = exchange.getRequestHeaders().getFirst("Origin");

        if (requestOrigin != null ){
            headers.set("Acess-Control-Allow-Origin", requestOrigin);
        }
//        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Methods", "GET, OPTIONS, POST, PUT, DELETE");
        headers.set("Access-Control-Allow-Headers", "Content-Type, Authorization");
        headers.set("Access-Control-Allow-Credentials", "true");
        headers.set("Access-Control-Allow-Headers", "Content-Type");


        }
    }




