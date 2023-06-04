package com.example.companion.data

import com.example.companion.R

data class Cities(
    val id: Int,
    val resId: Int,
    val cityname:String,
    val desc: String
) :ListItem(){
    companion object{
        private val cities= listOf(
            Cities(getUUID(), R.drawable.rome,"Rome","Ancient Ruins: Rome is home to incredible ancient ruins, such as the Colosseum, Roman Forum, and Palatine Hill. These sites offer a glimpse into the city's rich history and are must-visit attractions for history enthusiasts. Located within Rome, Vatican City is the smallest independent state in the world and the spiritual center of the Catholic Church. Visitors can explore St. Peter's Basilica, the Vatican Museums, and marvel at the breathtaking Sistine Chapel painted by Michelangelo. Rome is a food lover's paradise. Indulge in traditional Italian dishes like pasta carbonara, pizza Romana, supplì (fried rice balls), and gelato. Don't forget to try the famous Roman Jewish dishes like artichokes, fried codfish, and ricotta tart."),

            Cities(getUUID(), R.drawable.newyork,"New York"," New York City is home to numerous iconic landmarks. Don't miss the Statue of Liberty, Times Square, Empire State Building, Brooklyn Bridge, Central Park, and Rockefeller Center. These sites define the city's skyline and offer unforgettable experiences.Museums and Art Galleries: NYC is a haven for art enthusiasts. Visit the Metropolitan Museum of Art (the Met), Museum of Modern Art (MoMA), Solomon R. Guggenheim Museum, and the Whitney Museum of American Art to admire masterpieces from various periods.Enjoy breathtaking views of the city from observation decks such as the Empire State Building, Top of the Rock at Rockefeller Center, or the One World Observatory at the World Trade Center. These vantage points offer panoramic views of the city's skyline."),
            Cities(getUUID(),R.drawable.paris,"Paris","Explore the charming neighborhood of Montmartre, known for its bohemian atmosphere and artistic heritage. Visit the famous Sacré-Cœur Basilica, wander through the narrow streets, and enjoy street performances and local artists. The iconic Eiffel Tower is a must-visit landmark in Paris. Climb to the top for breathtaking views of the city or enjoy a picnic in the nearby Champ de Mars park.Parks and Gardens: Escape the bustling city and relax in the beautiful parks and gardens of Paris. Visit Jardin du Luxembourg, Parc des Buttes-Chaumont, or Jardin des Tuileries for a tranquil retreat."),
            Cities(getUUID(), R.drawable.lagrad,"Las Vegas","Las Vegas is renowned for its world-class casinos and entertainment options. Try your luck at the slot machines or table games, catch a thrilling live show, or enjoy performances by world-famous musicians, magicians, and comedians. The iconic Las Vegas Strip is a vibrant, 4.2-mile stretch of resorts, casinos, and entertainment venues. Take a stroll along the Strip and marvel at the dazzling lights, themed hotels, and famous landmarks like the Bellagio Fountains. Discover the history of Las Vegas through its iconic neon signs at the Neon Museum. Take a guided tour to learn about the city's rich heritage and see beautifully restored neon signs from famous hotels and casinos."),
            Cities(getUUID(),R.drawable.prag,"Prauge","\n" +
                    "Certainly! Here's some general information for tourists about Prague:\n" +
                    "\n" +
                    "Prague, the capital city of the Czech Republic, is a destination that offers a rich blend of history, stunning architecture, and a vibrant cultural scene. Here are some highlights for visitors:\n" +
                    "\n" +
                    "Architecture: Prague is renowned for its architectural beauty, with a mix of styles spanning from Gothic and Renaissance to Baroque and Art Nouveau. The city's skyline is adorned with breathtaking landmarks such as Prague Castle, Charles Bridge, and St. Vitus Cathedral.\n" +
                    "\n" +
                    "Historic Center: The historic center of Prague, a UNESCO World Heritage site, is a treasure trove of narrow cobblestone streets, picturesque squares, and well-preserved medieval buildings. The Old Town Square, with its Astronomical Clock and stunning Gothic architecture, is a focal point for visitors.")



        )




        fun getAllCities()= cities
    }



}