Given an undirected graph with maximum degree D, find a 
graph coloring using at most D + 1 colors.

*************************************************

Solution:
We go through the nodes in one pass, assigning each node the first legal color
we find.
How can we be sure we'll always have at least one legal color for every node? 
In a graph with maximum degree D, each node has at most D neighbors.That means 
there are at most D colors taken by a node's neighbors. And we have D+1 colors, 
so there's always at least one color left to use.
When we color each node, we're careful to stop iterating over the colors as 
soon as we find a legal color.
Complexity
O(N+M) time where N is the number of nodes and M is the number of edges.
The runtime might not look linear because we have outer and inner loops.The 
trick is to look at each step and think of things in terms of the total number 
of edges(M) wherever we can:
1. We check if each node appears in its own hash set of neighbors. Checking if 
something is in a hash set is O(1), so doing it for all N nodes is O(N).
2. When we get the illegal colors for each node, we iterate through that node's
neighbors. So in total, we cross each of the graphs M edges twice: once for the node
on either end of each edge. O(M) time.
3. When we assign a color to each node, we're careful to stop checking colors as 
soon as we find one that works. In the worst case, we'll have to check one more 
color than the total number of neighbors. Again, each edge in the graph adds two neighbors - one for the node on either end - so there are 2 * M neighbors. So,
in total, we'll have to try O(N+M) colors.

Putting all the steps together, our complexity is O(N+M).

What about space complexity? The only thing we're storing is the illegalColors hash
set. In the worst case, all the neighbors of a node with the maximum degree(D) have
different colors, so our hash set takes up O(D) space.

What We Learned

We used a greedy approach to build up a correct solution in one pass through the nodes.
This brought us close to the optimal runtime, but we also had to take that last step 
of iterating over the colors only until we find a legal color. Sometimes stopping a loop like that is just a premature optimization that doesn't bring down the final 
runtime, but here it actually made our runtime linear!