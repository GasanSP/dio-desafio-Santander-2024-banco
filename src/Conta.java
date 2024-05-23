public abstract class Conta {

    protected static final int AGENCIA_PADRAO = 0;
    public static int SEQUENCIAL = 1;

    public boolean statusSaque;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor){

        if(valor > saldo){
            System.out.println("ERRO: saldo insuficiente");
            statusSaque = false;
        }else{
            saldo -= valor;
            statusSaque = true;
        }

    }

    public void depositar(double valor){
        saldo += valor;

    }

    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        if(statusSaque) {
            contaDestino.depositar(valor);
        }else{
            System.out.println("ERRO: Transferência não realizada");
        }

    }

    protected void imprimirDados() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public abstract void imprimirExtrato();
}
