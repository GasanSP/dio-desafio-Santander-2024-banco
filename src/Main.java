public class Main {

    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.setNome("Genivaldo");

        Conta cc = new ContaCorrente(c1);
        cc.depositar(200);
        Conta poupanca = new ContaPoupanca(c1);
        cc.sacar(180);
        cc.transferir(150,poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
