import TDA.*;
import javax.swing.JOptionPane;

public class Banco <T> {

    private ListaSE<Cuenta> listaDeCuentas;
    private ListaSE<Solicitud> listaDeSolicitudes;
    private ListaSE<Cliente> listaDeClientes;

    public Banco(ListaSE<Cuenta> listaDeCuentas, ListaSE<Solicitud> listaDeSolicitudes, ListaSE<Cliente> listaDeClientes){
        this.listaDeCuentas = listaDeCuentas;
        this.listaDeSolicitudes = listaDeSolicitudes;
        this.listaDeClientes = listaDeClientes;
    }

    public ListaSE<Cuenta> getListaDeCuentas() {
        return listaDeCuentas;
    }
    public void setListaDeCuentas(ListaSE<Cuenta> listaDeCuentas) {
        this.listaDeCuentas = listaDeCuentas;
    }
    public ListaSE<Solicitud> getListaDeSolicitudes() {
        return listaDeSolicitudes;
    }
    public void setListaDeSolicitudes(ListaSE<Solicitud> listaDeSolicitudes) {
        this.listaDeSolicitudes = listaDeSolicitudes;
    }
    public ListaSE<Cliente> getListaDeClientes(){
        return listaDeClientes;
    }
    public void setListaDeClientes(ListaSE<Cliente> listaDeClientes){
        this.listaDeClientes = listaDeClientes;
    }

    public int verificarCuenta(){
        if (listaDeSolicitudes.isEmpty()){
            System.out.println("la lista de solicitudes esta vacía");
            return -1;
        }
        int idSol = listaDeSolicitudes.get(0).getId();
        NodoSE temp = listaDeCuentas.getHead();
        int count = 0;
        while (temp != null){
            int idCuenta = listaDeCuentas.get(count).getId();
            if (idSol == idCuenta){
                System.out.println("Cuenta encontrada, su posición es la siguiente:");
                return listaDeCuentas.get(count).getPos();
            }
            temp = temp.getNext();
            count++;
        }
        System.out.println("Cuenta no encontrada. \n Creando cuenta...");
        JOptionPane.showConfirmDialog(null, temp);
        Cuenta cuenta = new Cuenta(idSol, 0, count+1, null);
        NodoSE nodoCuenta = new NodoSE<Cuenta>(cuenta, null);
        listaDeCuentas.add(nodoCuenta);
        System.out.println("Cuentra creada y añadida a la lista, su posición es la siguiente:");
        return listaDeCuentas.get(count).getPos();
    };
    public void atenderTodo(){
        NodoSE temp = listaDeSolicitudes.getHead();
        while (temp != null){
            Solicitud sol = (Solicitud) temp.getVal();
            int posCuenta = verificarCuenta();
            double deposito = sol.getDeposit();
            Cuenta cuenta = listaDeCuentas.get(posCuenta);
            if (deposito > 0){
                cuenta.setSaldo(cuenta.getSaldo()+deposito);
            } else if(deposito <= cuenta.getSaldo()){
                cuenta.setSaldo(cuenta.getSaldo()-deposito);
            } else {
                System.out.println("Cantidad invalida");
            }
            temp = temp.getNext();
            listaDeSolicitudes.delete(0);
        }
        System.out.println("Solicitudes atendidas satisfactoriamente");
    };
    public ListaSE adiosMillos(){
        NodoSE temp = listaDeCuentas.getHead(), copy = null;
        int pos = 0, count = 0;
        double saldo;
        ListaSE millos = new ListaSE<Cuenta>(null);
        while (temp != null){
            saldo = listaDeCuentas.get(pos).getSaldo();
            if (saldo > 1000000){
                copy = new NodoSE(temp.getVal(), null);
                millos.add(copy);
                temp = temp.getNext();
                listaDeCuentas.delete(pos);
                if (pos < listaDeCuentas.length()){
                    listaDeCuentas.get(pos).setPos(pos);
                }
                Cuenta c = (Cuenta) millos.get(count);
                c.setPos(count);
                count++;
            } else {
                temp = temp.getNext();
                listaDeCuentas.get(pos).setPos(pos);
                pos++;
            }
        }
        System.out.println("Cuentas millonarias eliminadas: ");
        millos.show();
        System.out.println("\n");
        return millos;
    };


    public void otroAñadir(int id, Cliente cliente){
        int pos = 0;
        NodoSE temp = listaDeCuentas.getHead();
        Cuenta prev;
        if (listaDeCuentas.isEmpty()){
            Cuenta cuenta = new Cuenta(id, 0, 0, cliente);
            NodoSE nodoCuenta = new NodoSE<Cuenta>(cuenta, null);
            NodoSE nodoCliente = new NodoSE<>(cliente, null);
            listaDeClientes.setHead(nodoCliente);
            listaDeCuentas.setHead(nodoCuenta);
        } else {
            while (temp != null){
                if (temp.getNext() == null){
                    prev = (Cuenta) temp.getVal();
                    pos = prev.getPos();
                }
                temp = temp.getNext();
            }
            Cuenta cuenta = new Cuenta(id, 0, pos+1, cliente);
            NodoSE nodoCuenta = new NodoSE<>(cuenta, null);
            NodoSE nodoCliente = new NodoSE<>(cliente, null);
            if (listaDeClientes.search(nodoCliente) == -1){
                listaDeClientes.add(nodoCliente);
            }
            listaDeCuentas.add(nodoCuenta);
        }
    }

    public void otroBorrar(int id){
        int counter = 0;
        NodoSE temp = listaDeCuentas.getHead();
        Cuenta cuenta;
        while (temp != null){
            cuenta = (Cuenta) temp.getVal();
            if (id == cuenta.getId()){
                temp = temp.getNext();
                listaDeCuentas.delete(cuenta.getPos());
            } else {
                temp = temp.getNext();
                cuenta.setPos(counter);
                counter++;
            }
        }
    }
    
    public int buscarCuenta(int idSol){
        NodoSE temp = listaDeCuentas.getHead();
        int count = 0;
        while (temp != null){
            int idCuenta = listaDeCuentas.get(count).getId();
            if (idSol == idCuenta){
                System.out.println("Cuenta encontrada, su posición es la siguiente:");
                return listaDeCuentas.get(count).getPos();
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    }
    
    public Cliente buscarClientePorId(int id){
        NodoSE temp = listaDeClientes.getHead();
        int count = 0;
        while (temp != null){
            int idCliente = listaDeClientes.get(count).getIdCliente();
            if (id == idCliente){
                return listaDeClientes.get(count);
            }
            temp = temp.getNext();
            count++;
        }
        return null;
    }
    
    public boolean millonarios(){
        NodoSE temp = listaDeCuentas.getHead();
        int count = 0;
        while (temp != null){
            double dinero = listaDeCuentas.get(count).getSaldo();
            if (dinero >= 1000000){
                return true;
            }
            temp = temp.getNext();
            count++;
        }
        return false;
    }
}
