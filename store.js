import { createStore } from "redux";

const initialState = {
    flightList:[],
};

const reducer =(state=initialState,action) => 
{
    const{type,payload}=action;
    const flightListCopy=[...state.flightList];
    switch (type) {
        case "FLIGHT_ADD":
            flightListCopy.push(payload);
            alert("Added");
            return{
                ...state,
                flightList:flightListCopy,
            };
        
            case "FLIGHT_DELETE":
                
                flightListCopy.splice(payload,1);
                alert("Deleted");

                return {
                    ...state,
                    flightList:flightListCopy,
                };    

        default:
            return state;
    }
    // return state;
}

const store = createStore(reducer);

export default store;