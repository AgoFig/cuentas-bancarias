package edu.tallerweb.cuentas;

/**
 * @author Ago
 *
 */
public class CajaAhorros extends AbstractCuenta {

	private Double saldo = 0.0;
	private Integer contador = 0;
	private static final Integer limiteSinRecargo = 5;
	private static final Integer recargo = 6;

	public void depositar(final Double monto) {
		if (monto > 0.0) {
			this.saldo += monto;
		} else {
			throw new CuentaBancariaException(
					"Esta intentando depositar un saldo negativo.");
		}
	}

	public void extraer(final Double monto) {
		this.contador++;

		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"Esta intentando retirar un monto negativo.");
		} else {

			if (this.saldo > monto) {
				this.saldo -= monto;
				if (contador > limiteSinRecargo) {
					this.saldo -= recargo;
				}
			} else {
				throw new CuentaBancariaException(
						"Esta intentando extraer mas dinero del que dispone.");
			}
		}
	}

	public Double getSaldo() {
		return this.saldo;
	}

}
