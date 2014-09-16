1. Functional stuff is easy to do in scala!! Any problem where you have to do
an operation on every element of a list is easy to do, as well as pattern
matching. Operations where you care about the index are more difficult, since
you have to do a takeRight, ect. Overall, we felt like for the first half
of the assignment we were fighting against the language and after we stopped
doing that and opted for more functional approaches (map, foreach, filter all
over the place), the language got way more awesome.

2. Allowing the _*2 to replace x => x*2 is some sweet syntactic sugar
in my opinion - Nathan disagrees. The paramaterization by explicit type with
the option to do something like Any is also awesome. The avoidance of
null through options also struck us as a good language decision.

3. Static functions must be defined in helper objects - this seems pretty
strange to me. The inability to change a particular index of a list is also
really annoying in certain situations. Overall, I totally understand why the
authors of the language decided to enforce such a strong system of immutability,
but it is really annoying at certain times. It would be great to have more acces
to the indicies as well, for example it would be great to do a map of an element
and its index to something else.

4. I would like to learn more about options, since they dont really make a ton
of sense to either of us. I would also personally love to know whats going on
underneath the hood with operations like foreach and map. Other than that
we both feel pretty good about the language.
