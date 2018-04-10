package lsg.buffs.rings;

import lsg.characters.Hero;

public class RingOfDeath extends Ring{
	
	private static float LIMIT = 0.5f ; 

	public RingOfDeath() {
		super("Ring of Death", 10000) ;
	}

	/**
	 * Donne un buff lorsque les points de vie sont inférieur à 50%
	 * @return
	 */
	@Override
	public float computeBuffValue() {
		if (hero != null){
			float gauge = (float)hero.getLife() / hero.getMaxLife() ;
			if(gauge <= LIMIT) return power ;
			else return 0f ;
		}else return 0f ;
	}

}
