package inheritance;

public class Developer extends Person {
	private String lang;
	
	public Developer(String name, String lang) {
		super(name);
		this.lang = lang;
	}

	@Override
	public void doWork() {
		code();
	}
	
	@Override
	public void relax() {
		System.out.println(this.getName() + " is playing foosball");
	}
	
	

	public void code() {
		System.out.println(this.getName() + " is coding in " + lang);
	}

	@Override
	public String toString() {
		return "Developer [lang=" + lang + ", getName()=" + getName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Developer other = (Developer) obj;
		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		return true;
	}

	
	
	
}
