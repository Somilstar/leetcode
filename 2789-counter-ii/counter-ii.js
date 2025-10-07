/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let newinit = init;

    const increment = () =>{
        return ++newinit;
    }
    const decrement = ()=>{
        return --newinit;
    }
    const reset = ()=>{
        newinit = init;
        return newinit;
    }

    return{
       increment,
       decrement,
       reset
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */