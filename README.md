# isp-assignmetn Solution and Runing App
since i read the assignment, here what i do 
1. make a work flow based on text
2. Learn about Maven, and use it
4. i put the "book_shelf" as an array, bookShelf[i][3] because it just had 3 column on it, and the total of row inputed by user with command create_book_shelf 5 (5 is the total of slot for the book_shelf)
5. at first user create book_shelf, the program will make 2 dimensional array with three column, the first one filled by number 1 - n and the rest of the column filled by "-"
6. input, when user input "put titles author", program will split the input by space, and then put the titles to book_shelf array where the column[1] is "-" and != with what the user input
7. list, when user input "list", program will looping book_shelf array, and where book_shelf[1] != "-", program will showing the list to user, so row who doesnt filled with book wouldn't not showing to user
8. remove, when user input "remove 3" (3 is the slot number), program will search from array book_shelf where is the slot three with looping, and replaced title and author (bookShelf[i][1],[i][2]) with "-", and the slot is free to use
9. find by, when user input find-by-blablabla, program will search the match sentence from the book_shelf array.
10. exit, the program use while do, so while the input is not "exit", the program will run looping.

# Run The App
since i use maven, so-as far as I know- we we should run the program by comman "java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App" from console in the project folder or we can alos from console, type "mvn clean install" and viola, the jar file is on target folder.

or, i also put the jar (ready to use) in the project folder.

I Assumed that you guys already installing maven