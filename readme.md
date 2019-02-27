# Single Lane Bridge Problem

What we want to achieve is having a single lane bridge with cars passing from each direction without crashes. Below are shown the print outs of the different solutions/scenarios in the repo.

Arguements are given in order:
- Red car population
- Blue car population
- Frequency of arrival
- Car wait time at bridge
- Amount of cars that move together

## No Crash Scenario (master)
5 Red[200ms], 2 Blue[200ms]
```
RedCar1 is crossing the bridge
						                        BlueCar1 is waiting to cross the bridge
RedCar2 is waiting to cross the bridge
						                        BlueCar2 is waiting to cross the bridge
RedCar3 is waiting to cross the bridge
RedCar4 is waiting to cross the bridge
RedCar5 is waiting to cross the bridge
RedCar1 crossed the bridge
					                        	BlueCar2 is crossing the bridge
						                        BlueCar2 crossed the bridge
RedCar4 is crossing the bridge
RedCar4 crossed the bridge
						                        BlueCar1 is crossing the bridge
						                        BlueCar1 crossed the bridge
RedCar3 is crossing the bridge
RedCar3 crossed the bridge
RedCar2 is crossing the bridge
RedCar2 crossed the bridge
RedCar5 is crossing the bridge
RedCar5 crossed the bridge
```

## Variable Wait Time Scenario (Random-Wait-Time)
5 Red[Var], 2 Blue[Var]

### Run 1
```
									BlueCar1 is crossing the bridge[10ms]
RedCar2 is waiting to cross the bridge
RedCar1 is crossing the bridge[8ms]
									BlueCar2 is waiting to cross the bridge
RedCar3 is waiting to cross the bridge
RedCar4 is waiting to cross the bridge
RedCar5 is waiting to cross the bridge
RedCar1 crossed the bridge
									BlueCar1 crossed the bridge
RedCar2 is crossing the bridge[30ms]
RedCar2 crossed the bridge
									BlueCar2 is crossing the bridge[22ms]
									BlueCar2 crossed the bridge
RedCar3 is crossing the bridge[11ms]
RedCar3 crossed the bridge
RedCar4 is crossing the bridge[4ms]
RedCar4 crossed the bridge
RedCar5 is crossing the bridge[29ms]
RedCar5 crossed the bridge
```

### Run 2
```
RedCar1 is crossing the bridge[39ms]
									BlueCar1 is waiting to cross the bridge
RedCar2 is waiting to cross the bridge
									BlueCar2 is waiting to cross the bridge
RedCar3 is waiting to cross the bridge
RedCar4 is waiting to cross the bridge
RedCar5 is waiting to cross the bridge
RedCar1 crossed the bridge
									BlueCar1 is crossing the bridge[18ms]
									BlueCar1 crossed the bridge
RedCar2 is crossing the bridge[2ms]
RedCar2 crossed the bridge
									BlueCar2 is crossing the bridge[45ms]
									BlueCar2 crossed the bridge
RedCar5 is crossing the bridge[25ms]
RedCar5 crossed the bridge
RedCar4 is crossing the bridge[14ms]
RedCar4 crossed the bridge
RedCar3 is crossing the bridge[18ms]
RedCar3 crossed the bridge
```

## With Collisions (Main-Args-Collisions)
```
RedCar1 is crossing the bridge
RedCar1 crossed the bridge
RedCar2 is crossing the bridge
				  <!> Collision is about to happen
									BlueCar1 is crossing the bridge
RedCar2 crossed the bridge
									BlueCar1 crossed the bridge
									BlueCar2 is crossing the bridge
									BlueCar2 crossed the bridge
```

## Without Collisions (Main-Args-No-Collision)
```
RedCar1 is crossing the bridge
RedCar1 crossed the bridge
RedCar2 is waiting to cross the bridge
RedCar2 is crossing the bridge
									BlueCar1 is waiting to cross the bridge
RedCar2 crossed the bridge
									BlueCar1 is crossing the bridge
									BlueCar2 is waiting to cross the bridge
									BlueCar1 crossed the bridge
									BlueCar2 is crossing the bridge
									BlueCar2 crossed the bridge
```

## Alternating Cars (Main-Args-Alternating)
```
RedCar1 is crossing the bridge
RedCar2 is waiting to cross the bridge
RedCar1 crossed the bridge
						-BlueCar time-
									BlueCar1 is crossing the bridge
									BlueCar1 crossed the bridge
						-RedCar time-
RedCar2 is crossing the bridge
									BlueCar3 is waiting to cross the bridge
RedCar2 crossed the bridge
						-BlueCar time-
									BlueCar3 is crossing the bridge
									BlueCar4 is waiting to cross the bridge
									BlueCar3 crossed the bridge
						-RedCar time-
RedCar3 is crossing the bridge
									BlueCar5 is waiting to cross the bridge
RedCar3 crossed the bridge
						-BlueCar time-
									BlueCar2 is crossing the bridge
									BlueCar2 crossed the bridge
					-No more RedCars remaining -> BlueCar time
									BlueCar4 is crossing the bridge
									BlueCar4 crossed the bridge
					-No more RedCars remaining -> BlueCar time
									BlueCar5 is crossing the bridge
									BlueCar5 crossed the bridge
						<End>
```
