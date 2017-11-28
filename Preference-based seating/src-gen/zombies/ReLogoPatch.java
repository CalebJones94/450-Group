package zombies;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.ast.Diffusible;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.space.SpatialException;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoPatch extends BasePatch{

	/**
	 * Sprouts (makes) a number of new humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> sproutHumans(int number, Closure closure) {
		AgentSet<zombies.relogo.Human> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Human");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Human){
				result.add((zombies.relogo.Human)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new humans and then executes a set of commands on the
	 * created humans.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created humans
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> sproutHumans(int number) {
		return sproutHumans(number,null);
	}

	/**
	 * Returns an agentset of humans from the patch of the caller.
	 * 
	 * @return agentset of humans from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Human> result = new AgentSet<zombies.relogo.Human>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"human")){
			if (t instanceof zombies.relogo.Human)
			result.add((zombies.relogo.Human)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of humans on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of humans at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Human> result = new AgentSet<zombies.relogo.Human>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"human")){
			if (t instanceof zombies.relogo.Human)
			result.add((zombies.relogo.Human)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Human>();
		}
	}

	/**
	 * Returns an agentset of humans on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of humans on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansOn(Patch p){
		AgentSet<zombies.relogo.Human> result = new AgentSet<zombies.relogo.Human>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"human")){
			if (t instanceof zombies.relogo.Human)
			result.add((zombies.relogo.Human)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of humans on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of humans on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansOn(Turtle t){
		AgentSet<zombies.relogo.Human> result = new AgentSet<zombies.relogo.Human>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"human")){
			if (tt instanceof zombies.relogo.Human)
			result.add((zombies.relogo.Human)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of humans on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of humans on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humansOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Human>();
		}

		Set<zombies.relogo.Human> total = new HashSet<zombies.relogo.Human>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(humansOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(humansOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Human>(total);
	}

	/**
	 * Queries if object is a human.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a human
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public boolean isHumanQ(Object o){
		return (o instanceof zombies.relogo.Human);
	}

	/**
	 * Returns an agentset containing all humans.
	 * 
	 * @return agentset of all humans
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public AgentSet<zombies.relogo.Human> humans(){
		AgentSet<zombies.relogo.Human> a = new AgentSet<zombies.relogo.Human>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Human.class)) {
			if (e instanceof zombies.relogo.Human){
				a.add((zombies.relogo.Human)e);
			}
		}
		return a;
	}

	/**
	 * Returns the human with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Human")
	public zombies.relogo.Human human(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Human)
			return (zombies.relogo.Human) turtle;
		return null;
	}

	/**
	 * Sprouts (makes) a number of new spawners and then executes a set of commands on the
	 * created spawners.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawners
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> sproutSpawners(int number, Closure closure) {
		AgentSet<zombies.relogo.Spawner> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Spawner");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Spawner){
				result.add((zombies.relogo.Spawner)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new spawners and then executes a set of commands on the
	 * created spawners.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created spawners
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> sproutSpawners(int number) {
		return sproutSpawners(number,null);
	}

	/**
	 * Returns an agentset of spawners from the patch of the caller.
	 * 
	 * @return agentset of spawners from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Spawner> result = new AgentSet<zombies.relogo.Spawner>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner")){
			if (t instanceof zombies.relogo.Spawner)
			result.add((zombies.relogo.Spawner)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of spawners on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of spawners at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Spawner> result = new AgentSet<zombies.relogo.Spawner>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"spawner")){
			if (t instanceof zombies.relogo.Spawner)
			result.add((zombies.relogo.Spawner)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Spawner>();
		}
	}

	/**
	 * Returns an agentset of spawners on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of spawners on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersOn(Patch p){
		AgentSet<zombies.relogo.Spawner> result = new AgentSet<zombies.relogo.Spawner>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"spawner")){
			if (t instanceof zombies.relogo.Spawner)
			result.add((zombies.relogo.Spawner)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawners on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of spawners on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersOn(Turtle t){
		AgentSet<zombies.relogo.Spawner> result = new AgentSet<zombies.relogo.Spawner>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"spawner")){
			if (tt instanceof zombies.relogo.Spawner)
			result.add((zombies.relogo.Spawner)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of spawners on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of spawners on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawnersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Spawner>();
		}

		Set<zombies.relogo.Spawner> total = new HashSet<zombies.relogo.Spawner>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(spawnersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(spawnersOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Spawner>(total);
	}

	/**
	 * Queries if object is a spawner.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a spawner
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public boolean isSpawnerQ(Object o){
		return (o instanceof zombies.relogo.Spawner);
	}

	/**
	 * Returns an agentset containing all spawners.
	 * 
	 * @return agentset of all spawners
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public AgentSet<zombies.relogo.Spawner> spawners(){
		AgentSet<zombies.relogo.Spawner> a = new AgentSet<zombies.relogo.Spawner>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Spawner.class)) {
			if (e instanceof zombies.relogo.Spawner){
				a.add((zombies.relogo.Spawner)e);
			}
		}
		return a;
	}

	/**
	 * Returns the spawner with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Spawner")
	public zombies.relogo.Spawner spawner(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Spawner)
			return (zombies.relogo.Spawner) turtle;
		return null;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> sproutUserTurtles(int number, Closure closure) {
		AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.UserTurtle){
				result.add((zombies.relogo.UserTurtle)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> sproutUserTurtles(int number) {
		return sproutUserTurtles(number,null);
	}

	/**
	 * Returns an agentset of userTurtles from the patch of the caller.
	 * 
	 * @return agentset of userTurtles from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<zombies.relogo.UserTurtle>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof zombies.relogo.UserTurtle)
			result.add((zombies.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of userTurtles on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of userTurtles at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<zombies.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"userTurtle")){
			if (t instanceof zombies.relogo.UserTurtle)
			result.add((zombies.relogo.UserTurtle)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.UserTurtle>();
		}
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<zombies.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof zombies.relogo.UserTurtle)
			result.add((zombies.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<zombies.relogo.UserTurtle> result = new AgentSet<zombies.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof zombies.relogo.UserTurtle)
			result.add((zombies.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.UserTurtle>();
		}

		Set<zombies.relogo.UserTurtle> total = new HashSet<zombies.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof zombies.relogo.UserTurtle);
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public AgentSet<zombies.relogo.UserTurtle> userTurtles(){
		AgentSet<zombies.relogo.UserTurtle> a = new AgentSet<zombies.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.UserTurtle.class)) {
			if (e instanceof zombies.relogo.UserTurtle){
				a.add((zombies.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserTurtle")
	public zombies.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.UserTurtle)
			return (zombies.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Sprouts (makes) a number of new zombies and then executes a set of commands on the
	 * created zombies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created zombies
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> sproutZombies(int number, Closure closure) {
		AgentSet<zombies.relogo.Zombie> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.sprout(number,closure,"Zombie");
		for (Turtle t : createResult){
			if (t instanceof zombies.relogo.Zombie){
				result.add((zombies.relogo.Zombie)t);
			}
		} 
		return result;
	}

	/**
	 * Sprouts (makes) a number of new zombies and then executes a set of commands on the
	 * created zombies.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created zombies
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> sproutZombies(int number) {
		return sproutZombies(number,null);
	}

	/**
	 * Returns an agentset of zombies from the patch of the caller.
	 * 
	 * @return agentset of zombies from the caller's patch
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesHere(){
	  Grid grid = getMyObserver().getGrid();
	  GridPoint gridPoint = grid.getLocation(this);
	  AgentSet<zombies.relogo.Zombie> result = new AgentSet<zombies.relogo.Zombie>();
	  for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"zombie")){
			if (t instanceof zombies.relogo.Zombie)
			result.add((zombies.relogo.Zombie)t);
		}
		return result;
	}

	/**
	 * Returns the agentset of zombies on the patch at the direction (ndx, ndy) from the
	 * caller.
	 * 
	 * @param nX
	 *            a number
	 * @param nY
	 *            a number
	 * @returns agentset of zombies at the direction (nX, nY) from the caller
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesAt(Number nX, Number nY){
		double dx = nX.doubleValue();
		double dy = nY.doubleValue();
		double[] displacement = {dx,dy};

		try{
		GridPoint gridPoint = Utility.getGridPointAtDisplacement(getGridLocationAsNdPoint(),displacement,getMyObserver());
		AgentSet<zombies.relogo.Zombie> result = new AgentSet<zombies.relogo.Zombie>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(gridPoint,getMyObserver(),"zombie")){
			if (t instanceof zombies.relogo.Zombie)
			result.add((zombies.relogo.Zombie)t);
		}
		return result;
		}
		catch(SpatialException e){
			return new AgentSet<zombies.relogo.Zombie>();
		}
	}

	/**
	 * Returns an agentset of zombies on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of zombies on patch p
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesOn(Patch p){
		AgentSet<zombies.relogo.Zombie> result = new AgentSet<zombies.relogo.Zombie>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"zombie")){
			if (t instanceof zombies.relogo.Zombie)
			result.add((zombies.relogo.Zombie)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of zombies on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of zombies on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesOn(Turtle t){
		AgentSet<zombies.relogo.Zombie> result = new AgentSet<zombies.relogo.Zombie>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"zombie")){
			if (tt instanceof zombies.relogo.Zombie)
			result.add((zombies.relogo.Zombie)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of zombies on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of zombies on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombiesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<zombies.relogo.Zombie>();
		}

		Set<zombies.relogo.Zombie> total = new HashSet<zombies.relogo.Zombie>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(zombiesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(zombiesOn(p));
				}
			}
		}
		return new AgentSet<zombies.relogo.Zombie>(total);
	}

	/**
	 * Queries if object is a zombie.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a zombie
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public boolean isZombieQ(Object o){
		return (o instanceof zombies.relogo.Zombie);
	}

	/**
	 * Returns an agentset containing all zombies.
	 * 
	 * @return agentset of all zombies
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public AgentSet<zombies.relogo.Zombie> zombies(){
		AgentSet<zombies.relogo.Zombie> a = new AgentSet<zombies.relogo.Zombie>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Zombie.class)) {
			if (e instanceof zombies.relogo.Zombie){
				a.add((zombies.relogo.Zombie)e);
			}
		}
		return a;
	}

	/**
	 * Returns the zombie with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Zombie")
	public zombies.relogo.Zombie zombie(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof zombies.relogo.Zombie)
			return (zombies.relogo.Zombie) turtle;
		return null;
	}

	/**
	 * Queries if object is a infection.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a infection
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public boolean isInfectionQ(Object o){
		return (o instanceof zombies.relogo.Infection);
	}

	/**
	 * Returns an agentset containing all infections.
	 * 
	 * @return agentset of all infections
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public AgentSet<zombies.relogo.Infection> infections(){
		AgentSet<zombies.relogo.Infection> a = new AgentSet<zombies.relogo.Infection>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.Infection.class)) {
			if (e instanceof zombies.relogo.Infection){
				a.add((zombies.relogo.Infection)e);
			}
		}
		return a;
	}

	/**
	 * Returns the infection between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return infection between two turtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection infection(Number oneEnd, Number otherEnd) {
		return (zombies.relogo.Infection)(this.getMyObserver().getNetwork("Infection").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the infection between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return infection between two turtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.Infection")
	public zombies.relogo.Infection infection(Turtle oneEnd, Turtle otherEnd) {
		return infection(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof zombies.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public AgentSet<zombies.relogo.UserLink> userLinks(){
		AgentSet<zombies.relogo.UserLink> a = new AgentSet<zombies.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(zombies.relogo.UserLink.class)) {
			if (e instanceof zombies.relogo.UserLink){
				a.add((zombies.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (zombies.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("zombies.relogo.UserLink")
	public zombies.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}

	/**
	 * Returns the value of the global variable numHumans.
	 *
	 * @return the value of the global variable numHumans
	 */
	@ReLogoBuilderGeneratedFor("global: numHumans")
	public Object getNumHumans(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numHumans");
	}

	/**
	 * Sets the value of the global variable numHumans.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numHumans")
	public void setNumHumans(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numHumans",value);
	}

	/**
	 * Returns the value of the global variable numZombies.
	 *
	 * @return the value of the global variable numZombies
	 */
	@ReLogoBuilderGeneratedFor("global: numZombies")
	public Object getNumZombies(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("numZombies");
	}

	/**
	 * Sets the value of the global variable numZombies.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: numZombies")
	public void setNumZombies(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("numZombies",value);
	}

	/**
	 * Returns the value of the global variable gestationPeriod.
	 *
	 * @return the value of the global variable gestationPeriod
	 */
	@ReLogoBuilderGeneratedFor("global: gestationPeriod")
	public Object getGestationPeriod(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("gestationPeriod");
	}

	/**
	 * Sets the value of the global variable gestationPeriod.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: gestationPeriod")
	public void setGestationPeriod(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("gestationPeriod",value);
	}


}