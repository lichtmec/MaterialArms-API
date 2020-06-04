package ma.api.smaterial;

/**
 * Interface for {@link SMaterial}.<br>
 * Define its properties as a flammable material.
 */
public interface ISMatFlammable
{
	/**
	 * The temperature that rises when this material is burned.
	 * 
	 * @return	rising temperature ( Kelvin/mB )
	 */
	int getRisesTempOnBurning ();
}