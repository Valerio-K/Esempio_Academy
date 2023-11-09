//JSON

let user = {
    name: 'Valerio',
    age: 25,
    siblings : ['Luca', 'Mario']
}

//cambio tipo alla variabile name, da String a Array
user.name = {names: ['Francesco']}

//aggiungo una proprietà postuma
user.parents = ['Marco','Giulia']

//elimino la proprietà indicata tramite delete
delete user.age

let user2 = {
    ...user,
    pets: ['Fuffy'],
    calculate_birth : () => {

    }
}

function modifyParam(key, value) {
    user[key]=value
}

function print() {
    document.write(JSON.stringify(user2))
}


//Array

let users = [1,'Ciao', {}, NaN]

users.push('Ultimo')
users.pop()
users.length

//aggiunta tramite spreadOper (sostituto di .push)
users = [...users, 'Ultimissimo']

//prima forma di FOR
for(let i=0; i<users.length; i++){
    users[i]
}

//forma alternativa di FOR
for(let user of users) {
    user
}


let users2 = users.map(mapUsers)

const mapUsers = (user,i) => {
    return {
        ...user,
        age: user.age + 20
    }
}

users.forEach((user,i) => {
    user.age=user.age+20
})

function printArray(array) {
    document.write("<table border=1>");
    document.write("<tr>");
    array.forEach(cursore=> {
        document.write("<td>");
        document.write(cursore);
        document.write("</td>");
    })
    document.write("</tr>");
    document.write("</table>");
    console.log(array)
}


const isNotMinor = (user) => {
    return user.age > 17 ? true : false
}

//filtro inserimento tramite function
let not_minor_users = users.filter(isNotMinor)

let io = users.find((user) => user.name === 'Valerio')

function print2() {
    let array = [1,2,3,4,5,6,7,8,9]
    let a1 = array.map((el) => el+10)
    let a2 = array.map((el) => el%2 ? 0 : el)
    let a3 = array.filter((el) => el%2==0)
    let a4 = array.map((e,i) => i%2 ? e+5 : e)
    let a5 = array.forEach((e,i) => {
        e+10
    })
    printArray(a4)
}

function print3() {
let people = [
    {
        name: 'Mario',
        surname: 'Rossi',
        age: 17
    },
    {
        name: 'Luca',
        surname: 'Bianchi',
        age: 20
    },
    {
        name: 'Alex',
        surname: 'Verdi',
        age: 18
    }
]

let over18people = people.filter(i => i && i.age >= 18)
                        .map(i => {
                            return {
                            ...i,
                            fullname: i.name+" "+i.surname}
})
printArray(JSON.stringify(over18people))
}
