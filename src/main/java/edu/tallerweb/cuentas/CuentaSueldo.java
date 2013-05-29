package edu.tallerweb.cuentas;

public class CuentaSueldo extends AbstractCuenta {

	private Double saldo;

	public CuentaSueldo() {
		this.saldo = 0.0;
	}

	public void depositar(final Double monto) {
		// throw new RuntimeException("No implementado aún");
		this.saldo += monto;
	}

	public void extraer(final Double monto) {

		if (monto < this.saldo) {
			this.saldo -= monto;
		} else {
			throw new CuentaBancariaException(
					"Esta intentando retirar mas dinero del que dispone en su cuenta.");
		}
	}

	public Double getSaldo() {
		// throw new RuntimeException("No implementado aún");
		return this.saldo;
	}

}
