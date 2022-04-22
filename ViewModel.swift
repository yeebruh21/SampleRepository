//
//  ViewModel.swift
//  Challenge
//
//  Created by Christopher Ching on 2021-01-15.
//

import Foundation

class ViewModel: ObservableObject {
    
    // Add the Published property wrapper to broadcast changes
    @Published var pizzas = [Pizza]()
    
    init() {
        
        // Create and add pizza 1 to the array
        var pizza1 = Pizza()
        pizza1.name = "Meat Lovers"
        pizza1.topping1 = "Pepperoni"
        pizza1.topping2 = "Bacon"
        pizza1.topping3 = "Sausage"
        
        pizzas.append(pizza1)
        
        // Create and add pizza 2 to the array
        var pizza2 = Pizza()
        pizza2.name = "Deluxe"
        pizza2.topping1 = "Pepperoni"
        pizza2.topping2 = "Mushroom"
        pizza2.topping3 = "Green Peppers"
        
        pizzas.append(pizza2)
        
        // Create and add pizza 3 to the array
        var pizza3 = Pizza()
        pizza3.name = "Hawaiian"
        pizza3.topping1 = "Ham"
        pizza3.topping2 = "Bacon"
        pizza3.topping3 = "Pineapple"
        
        pizzas.append(pizza3)
        
    }
    
    func addPineapple() {
        
        // Changing the property value of an object won't trigger a "change" in the pizzas array so our SwiftUI List won't be notified and thus the UI won't update.
        // One "hack" could be to simply remove the last element and re-append it
        // If you do this, the array is changing so it will broadcast a change
        // let lastPizza = pizzas.removeLast()
        // pizzas.append(lastPizza)
        
        // Other things you could do:
        // call pizzas.shuffle() but this would change the order
        
        // Change the Pizza class to a struct which is what I did for this solution.
    
        // That's why we're using an index based For loop.
        // If you used a loop like this "for p in pizzas { }", the struct instance would be copied into "p" for each iteration of the loop and you won't be able to modify the copy in "p".
        for i in 0..<pizzas.count {
            
            // Change the topping1 property to pineapple
            pizzas[i].topping1 = "Pineapple"
        }
        
        // In the upcoming modules, we'll look at other data flow techniques so we won't have to rely on things like the above.
    }
    
}
