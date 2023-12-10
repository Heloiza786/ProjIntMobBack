package senac.java.Domain;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Agendamentos {
    int id;
    String name = "";
    String lastName = "";
    String cpf = "";
    String email = "";
    String horario ="";
    String pelagem ="";
    String especie="";
    String raca="";
    public Agendamentos() {

    }

    public Agendamentos(String name, String lastName,
                        String cpf, String email, String horario,
                        String pelagem, String especie, String raca) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.horario = horario;
        this.pelagem = pelagem;
        this.especie = especie;
        this.raca = raca;


    }

    public String getUser() {
        return name;
    }

    public void setUser(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFinishedSales() {
        return cpf;
    }

    public void setFinishedSales(String finishedSale) {
        this.cpf = cpf;
    }

    public String getDiscount() {
        return email;
    }

    public void setDiscount(String discount) {
        this.email = email;
    }

    public String getHorario(){ return horario;}

    public void setHorario(String horario) {this.horario = horario;}

    public String getPelagem(){ return pelagem;}
    public void setPelagem(String pelagem) {this.pelagem = pelagem;}

    public String getEspecie(){ return especie;}
    public void setEspecie(String especie) {this.especie= especie;}


    public String getRaca(){ return raca;}
    public void setRaca(String raca) {this.raca =raca;}

    public JSONObject toJson() {

        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("lastName", lastName);
        json.put("cpf", cpf);
        json.put("email", email);
        json.put("horario", horario);
        json.put("pelagem", pelagem);
        json.put("especie", especie);
        json.put("raca", raca);

        return json;
    }

    public JSONObject arrayToJson(List<Agendamentos> vendaListArray) {
        JSONObject json = new JSONObject();

        if (!vendaListArray.isEmpty()) {
            var keyJson = 0;
            for (Agendamentos agend : vendaListArray) {
                JSONObject jsonObjectPut = new JSONObject();


                jsonObjectPut.put("name", agend.getUser());
                jsonObjectPut.put("lastName", agend.getLastName());
                jsonObjectPut.put("cpf", agend.getFinishedSales());
                jsonObjectPut.put("email", agend.getDiscount());
                jsonObjectPut.put("horaio", agend.getHorario());
                jsonObjectPut.put("pelagem", agend.getPelagem());
                jsonObjectPut.put("especie", agend.getEspecie());
                jsonObjectPut.put("raca", agend.getRaca());




                json.put(String.valueOf(keyJson), jsonObjectPut);
                keyJson++;


            }
            return json;

        } else {
            return null;
        }
    }

    public ArrayList userList() {
        ArrayList list = new ArrayList();
        list.getClass();

        return list;
    }

}

