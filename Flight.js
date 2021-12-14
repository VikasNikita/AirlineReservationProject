import {useState,useEffect} from "react";
// import axios from "axios";

export default () => {
    const [FlightList,setFlightList]=useState([]);
    const [name,setName]=useState("");
    const [sourceLoc,setSourceLoc]=useState("");
    const [destinationLoc,setDestinationLoc]=useState("");
    const [departureDateTime,setDepartureDateTime]=useState("");
    const [arrivalDateTime,setArrivalDateTime]=useState("");
    const [economySeatPrice,setEconomySeatPrice]=useState("");
    const [businessSeatPrice,setBusinessSeatPrice]=useState("");
    const [totalEconomySeats,setTotalEconomySeats]=useState("");
    const [totalBusinessSeats,setTotalBusinessSeats]=useState("");
    const [availableEconomySeats,setAvailableEconomySeats]=useState("");
    const [availableBusinessSeats,setAvailableBusinessSeats]=useState("");

    const onNameChange = (event) => {
        setName(event.target.value);
    };

    const onSourceChange = (event) => {
        setSourceLoc(event.target.value);
    };

    const onDestinationChange = (event) => {
        setDestinationLoc(event.target.value);
    };

    const onDepartureDateTime = (event) => {
        setDepartureDateTime(event.target.value);
    };

    const onArrivalDateTimeChange = (event) => {
        setArrivalDateTime(event.target.value);
    };

    const onEconomySeatPriceChange = (event) => {
        setEconomySeatPrice(event.target.value);
    };

    const onBusinessSeatPrice = (event) => {
        setBusinessSeatPrice(event.target.value);
    };

    const onTotalEconomySeatsChange = (event) => {
        setTotalEconomySeats(event.target.value);
    };

    const onTotalBusinessSeatsChange = (event) => {
        setTotalBusinessSeats(event.target.value);
    };

    const onAvailableEconomySeatsChange = (event) => {
        setAvailableEconomySeats(event.target.value);
    };

    const onAvailableBusinessSeatsChange = (event) => {
        setAvailableBusinessSeats(event.target.value);
    };
    return (<>
        <h1>Flight Form</h1>
        <br/>
        <form>
        <div  className="mb-3">
        <label className="form-label" >Flight Name</label>
        <input name="name" value={name} placeholder="Enter Flight Name" onChange={setName}/>
        <br/>
        <br/>
        </div>
        <div  className="mb-3">
        <label className="form-label">Source Location</label>
        <input name="sourceLoc" value={sourceLoc} placeholder="Enter Source Location" onChange={setSourceLoc}/>
        <br/>
        <br/>
        </div>
        <div  className="mb-3">
        <label className="form-label">Destination Location</label>
        <input name="destinationLoc" value={destinationLoc} placeholder="Enter Destinetion Location" onChange={setDestinationLoc}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label">DepartureDateTime</label>
        <input type="datetime-local" value={departureDateTime} onChange={setDepartureDateTime}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" >ArrivalDateTime</label>
        <input type="datetime-local" value={arrivalDateTime} placeholder="Flight Name" onChange={setArrivalDateTime}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" >EconomySeatPrice</label>
        <input name="economySeatPrice" value={economySeatPrice}placeholder="Enter EconomySeatPrice" onChange={setEconomySeatPrice}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" placeholder="Enter BusinessSeatPrice">BusinessSeatPrice</label>
        <input name="businessSeatPrice" value={businessSeatPrice} placeholder="Enter Business Seat Price" onChange={setBusinessSeatPrice}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" >TotalEconomySeats</label>
        <input name="totalEconomySeats" value={totalEconomySeats} placeholder=" Enter TotalEconomySeats" onChange={setTotalEconomySeats}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <lable className="form-label" >TotalEconomySeats</lable>
        <input name="totalBusinessSeats" value={totalBusinessSeats} placeholder="Enter TotalEconomySeats" onChange={setTotalBusinessSeats}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" >AvailableEconomySeats</label>
        <input name="availableEconomySeats" value={availableEconomySeats} placeholder="Enter Available Seat Price" onChange={setAvailableEconomySeats}/>
        <br/>
        <br/>
        </div>
        <div className="mb-3">
        <label className="form-label" className="Available Business Seat">Available BusinessSeat</label>
        <input name="availableBusinessSeats" value={availableBusinessSeats} placeholder="Enter Available Business Seat" onChange={setAvailableBusinessSeats}/>
        <br/>
        </div>
        <button type="submit" className="btn btn-success">Submit</button>
    </form>
        
    </>
        );
//     const FetchData = () => {
//         axios.get("http://localhost:8080/flight/getAll").then((response) => {
//         console.log(response.data);
//         if (response && response.data) {
//             setFlightList(response.data);
//         }
//     });


//     useEffect (() => {
//         FetchData();
//     },[]);
// };
//     return(
//         <>
//             <h1>Flight Form</h1>
//             <lable>Flight Name:</lable>
//             <input/>
//             <lable>Source Location:</lable>
//             <input/>
//             <lable>Destination Location:</lable>
//         </>
//     );
}
