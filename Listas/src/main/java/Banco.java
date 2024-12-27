import TDA.*;
import javax.swing.JOptionPane;

public class Banco <T> {
    
    private ListaSE<Solicitud> listaDeSolicitudes;
    private ListaSE<Cliente> listaDeClientes;
    private ListaSE<Deposito> listaDeDepositos;
    private ListaSE<Retiro> listaDeRetiros;

    public Banco(ListaSE<Solicitud> listaDeSolicitudes, ListaSE<Cliente> listaDeClientes, ListaSE<Deposito> listaDeDepositos,
    ListaSE<Retiro> listaDeRetiros){
        this.listaDeSolicitudes = listaDeSolicitudes;
        this.listaDeClientes = listaDeClientes;
        this.listaDeDepositos = listaDeDepositos;
        this.listaDeRetiros = listaDeRetiros;
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

    public int verificarCuenta(int idCliente, int idCuenta){
        int count = 0;
        Cliente cl = buscarClientePorId(idCliente);
        NodoSE<Cuenta> temp = cl.getCuentas().getHead();
        while (temp != null){
            Cuenta cuenta = (Cuenta) temp.getVal();
            int id = cuenta.getId();
            if (id == idCuenta){
                return cuenta.getPos();
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    };
    
    public void atenderTodo(){
        NodoSE temp = listaDeSolicitudes.getHead();
        NodoSE clienteN = listaDeClientes.getHead();
        while (temp != null){
            if (clienteN == null){
                clienteN = listaDeClientes.getHead();
            }
            Solicitud sol = (Solicitud) temp.getVal();
            Cliente cliente = (Cliente) clienteN.getVal();
            int idCliente = cliente.getIdCliente();
            int idCuenta = sol.getId();
            int posCuenta = verificarCuenta(idCliente, idCuenta);
            while (posCuenta == -1 && clienteN != null){
                clienteN = clienteN.getNext();
                cliente = (Cliente) clienteN.getVal();
                idCliente = cliente.getIdCliente();
                posCuenta = verificarCuenta(idCliente, idCuenta);
            }
            if (posCuenta != -1){
                double deposito = sol.getDeposit();
                Cuenta cuenta = (Cuenta) cliente.getCuentas().get(posCuenta);
                if (deposito > 0){
                    cuenta.setSaldo(cuenta.getSaldo()+deposito);
                } else {
                    System.out.println("Cantidad invalida");
                }
                temp = temp.getNext();
                listaDeSolicitudes.delete(0);
            }
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
            Cuenta cuenta = new Cuenta(id, 0, 0);
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
            Cuenta cuenta = new Cuenta(id, 0, pos+1);
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
