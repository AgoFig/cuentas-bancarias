package edu.tallerweb.cuentas;

/**
 * @author Ago
 * 
 */
public class CuentaCorriente extends AbstractCuenta {

	private Double saldo;
	private Double descubiertoMaximo;
	private Double descubiertoDisponible;
	private Double recargo = (Double) 0.05;

	public CuentaCorriente(final Double descubiertoTotal) {
		this.saldo = 0.0;
		this.descubiertoMaximo = descubiertoTotal;
		this.descubiertoDisponible = descubiertoMaximo;
	}

	public void depositar(final Double monto) {

		Double descubiertoUtilizado;

		descubiertoUtilizado = this.descubiertoMaximo
				- this.descubiertoDisponible;

		if (monto > descubiertoUtilizado) {
			this.saldo += monto;
		} else {
			throw new RuntimeException(
					"El monto a depositar es menor al descubierto actual");
		}

	}

	public void extraer(final Double monto) {
		Double totalDisponible;
		Double descubiertoConRecargo;
		Double descubiertoUsado;

		totalDisponible = this.descubiertoMaximo + this.saldo;

		if (monto < 0) {
			throw new CuentaBancariaException(
					"Esta intentando extraer mas alla del descubierto autorizado");
		}

		if (monto <= saldo) {
			this.saldo -= monto;
		} else {
			if (monto <= totalDisponible) {

				descubiertoUsado = (monto - this.saldo);
				descubiertoConRecargo = (descubiertoUsado + (descubiertoUsado * this.recargo));

				this.descubiertoDisponible -= descubiertoConRecargo;
				this.saldo = 0.0;

			} else {
				throw new CuentaBancariaException(
						"Esta intentando extraer mas alla del descubierto autorizado");
			}
		}

	}

	public Double getSaldo() {
		return this.saldo;
	}

	public Double getDescubierto() {
		return this.descubiertoDisponible;
	}

}
