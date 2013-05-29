package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {

	private Double saldo;
	private Integer contador;
	private Integer limiteSinRecargo;
	private Integer recargo;

	public CajaAhorros() {
		this.saldo = 0.0;
		this.contador = 0;
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
						"Esta intentando extraer mas dinero del que dispone en su Caja de Ahorros");
			}
		}
	}

	public Double getSaldo() {
		return this.saldo;
	}

}
