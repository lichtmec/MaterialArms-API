package ma.api.item;

public interface IModifiProperty
{
	public static class ResistProperty
	{
		public float raito;
		public int limit;
		
		public ResistProperty (float raito, int limit)
		{
			this.raito = raito;
			this.limit = limit;
		}
		
		public static ResistProperty compProperty (ResistProperty prop0, ResistProperty prop1)
		{
			return new ResistProperty(prop0.raito + prop1.raito, prop0.limit + prop1.limit);
		}
	}
}