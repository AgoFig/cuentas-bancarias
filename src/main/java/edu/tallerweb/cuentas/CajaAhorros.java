package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {

	private Double saldo;
	private Integer contador;

	public CajaAhorros() {
		this.saldo = 0.0;
		this.contador = 0;
	}

	public void depositar(final Double monto) {
		this.saldo += monto;
	}

	public void extraer(final Double monto) {
		this.contador++;
		if (this.saldo > monto) {
			this.saldo -= monto;
			if (contador > 5) {
				this.saldo -= 6;
			}
		} else {
			throw new CuentaBancariaException(
					"Esta intentando extraer mas dinero del que dispone en su Caja de Ahorros");
		}

	}

	/**
	 * Permite saber el saldo de la cuenta
	 * 
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return this.saldo;
	}

}
