/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let newinit = init;
    return{
        increment(){
            return ++newinit;
        },
        decrement(){
            return --newinit;
        },
        reset(){
            newinit = init
            return newinit
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */