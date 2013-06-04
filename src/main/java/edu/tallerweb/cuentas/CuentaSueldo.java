package edu.tallerweb.cuentas;

/**
 * @author Ago
 * 
 */
public class CuentaSueldo extends AbstractCuenta {

	private Double saldo;

	public CuentaSueldo() {
		this.saldo = 0.0;
	}

	public void depositar(final Double monto) {
		if (monto > 0.0) {
			this.saldo += monto;
		} else {
			throw new CuentaBancariaException(
					"Esta intentando depositar un saldo negativo.");
		}
	}

	public void extraer(final Double monto) {
		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"Esta intentando retirar un monto negativo.");
		}

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
