package solver;

import java.util.*;
import main.MazeGridPanel;
import util.Cell;

public class DijkstraSolve extends BasicSolver {
	
	private final Stack<Cell> queue = new Stack<>();

	public DijkstraSolve(List<Cell> grid, MazeGridPanel panel) {
		super(grid, panel);
		queue.push(current);
	}

	protected void flood() {
		current.setDeadEnd(true);
		current = queue.pop();
		List<Cell> adjacentCells = current.getValidMoveNeighbours(grid);
		for (Cell c : adjacentCells) {
			if (update_distance(c)) {
				queue.push(c);
			}
		}
	}
	
}