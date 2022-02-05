// a conta abstrata permite que não seja criado um objeto new dela propria e sim das heranças.

public abstract class Conta implements IConta {

    //static faz com que o sequencial aumente conforme novas contas são criadas.
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    // ↑ private faz com que só consiga acessar na classe deferida.
    // ↓ Com protected consigo puxar nas heranças com super.
    protected int agencia;
    protected int numero;
    protected int saldo;

    //construtores

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    //metodos implementados

    @Override
    public void sacar(double valor) {
        if (this.saldo < valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    //metodos
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public int getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.numero);
        System.out.println("Saldo: " + this.saldo);


    }
}


