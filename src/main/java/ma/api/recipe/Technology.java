package ma.api.recipe;

public final class Technology
{
	public final String name;
	public final short maxLevel;
	
	public Technology (String name, short maxLevel)
	{
		this.name = name;
		this.maxLevel = maxLevel;
	}
	
	public Technology (String name, int maxLevel)
	{
		this(name, (short)maxLevel);
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public short getMaxLevel ()
	{
		return this.maxLevel;
	}

	public static final class UnderlyingTechnology implements Cloneable
	{
		public Technology tech;
		public short level;

		public UnderlyingTechnology (Technology tech, short level)
		{
			this.tech = tech;
			this.level = level;
		}

		public String getTechName ()
		{
			return this.tech.getName();
		}

		public short getTechLevel ()
		{
			return this.level;
		}

		public UnderlyingTechnology setTechLevel (short level)
		{
			this.level = level;

			return this;
		}

		@Override
		public boolean equals (Object obj)
		{
			if (obj instanceof UnderlyingTechnology)
			{
				UnderlyingTechnology checkObj = (UnderlyingTechnology)obj;

				if (tech.getName().equals(checkObj.getTechName()) && getTechLevel() == checkObj.getTechLevel())
				{
					return true;
				}
			}

			return false;
		}

		@Override
		public UnderlyingTechnology clone ()
		{
			return new UnderlyingTechnology(this.tech, this.level);
		}
	}
}