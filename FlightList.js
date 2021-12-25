import axios from "axios";
import { useState } from "react"
import { useEffect } from "react";

export default  () =>
 {
     const[flightList,setFlightList]=useState([]);
     const [flightNameEditMode,setFlightNameEditMode]=useState("");
     const [flightSourceLocationEditMode,setflightSourceLocationEditMode]=useState("");
     const [flightDestinationLocationEditMode,setflightDestinationLocationEditMode]=useState("");
     const [departureDateTimeEditMode,setDepartureDateTimeEditMode]=useState(new Date());
     const [arrivalDateTimeEditMode,setArrivalDateTimeEditMode]=useState(new Date());
     const [economySeatPriceEditMode,setEconomySeatPriceEditMode]=useState(0);
     const[businessSeatPriceEditMode,setBusinessSeatPriceEditMode]=useState(0);
     const[totalBusinessSeatsEditMode,setTotalBusinessSeatsEditMode]=useState(0);
     const[totalEconomySeatsEditMode,setTotalEconomySeatsEditMode]=useState(0);
     const[availableBusinessSeatsEditMode,setAvailableBusinessEditMode]=useState(0);
     const[availableEconomySeats,setAvailableEconomySeatsEditMode]=useState(0);
     const[isEditMode,setEditMode]=useState(false);
     const[flightID,setFlightID]=useState(0);
     const[selectedFlightId,setSelectedFlightId]=useState(-1);
     const[editObject,setEditObject]=useState({});
     const [flightObject,setflightObject]=useState({
         flightName:"",
         sourceLoc:"",
         destinationLoc:"",
         economySeatPrice:0,
         businessSeatPrice:0,
         totalbusinessSeats:0,
         totalEconomySeats:0,
         availableBusinessSeats:0,
         availableEconomySeats:0,
     });


    const FetchData =() =>{ 
        axios.get("http://localhost:8080/flight/getAll").then((response) => {
        console.log(response.data);
        if(response && response.data)
        {
             setFlightList(response.data);
        }
     });
    }
    
     useEffect(() => {
     },[])

      const onFromSubmit =(event) =>{
         event.preventDefault();
        if(!isEditMode){
        axios.post("http://localhost:8080/flight/Add",{
            ...flightObject,
        }).then((response) =>{
            console.log(response);
            alert("Added");
          
            setflightObject({
                flightName:"",
                sourceLoc:"",
                departureDateTime:new Date(),
                arrivalDateTime:new Date(),
                economySeatPrice:0,
                businessSeatPrice:0,
                totalEconomySeats:0,
                totalbusinessSeats:0,
                availableBusinessSeats:0,
                availableEconomySeats:0,
            });
            FetchData();
        });
    
    }
}

      const onDeleteHandler =(flightId)=>{
        
            axios.delete("http://localhost:8080/flight/delete/"+flightId).then((response)=>{
            console.log(response);
            alert("Deleted");
            FetchData();
        })
    }

      const onEdit =(flightObject) =>{
          console.log(flightObject);
        setFlightNameEditMode(flightObject.flightName);
        setflightSourceLocationEditMode(flightObject.sourceLoc);
        setflightDestinationLocationEditMode(flightObject.destinationLoc);
        setEconomySeatPriceEditMode(flightObject.economySeatPrice);
        setBusinessSeatPriceEditMode(flightObject.businessSeatPrice);
        setTotalBusinessSeatsEditMode(flightObject.totalbusinessSeats);
        setTotalEconomySeatsEditMode(flightObject.totalEconomySeats);
        setArrivalDateTimeEditMode(flightObject.arrivalDateTime);
        setDepartureDateTimeEditMode(flightObject.departureDateTime);
        setFlightID(flightObject.flightId);
        setSelectedFlightId(flightObject.flightId);
        setEditObject({
            ...flightObject
        })
      };

    const onEditObjectChangeHandler = (event) =>
     {
        if(event) {
            const {name,value}=event.target;
            setEditObject ({
                ...editObject,
                [name]:value,
            })
        }

      };
      const onFlightObjectChangeHandler = (event) => {
        if(event)
        {
            const {name,value}=event.target;
            setflightObject ({
                ...flightObject,
                [name]:value,
            })

        }
      };
     

      const onResetRowHandler = () => {
          setSelectedFlightId(-1);
          setEditObject({
              flightName:"",
              sourceLoc:"",
              destinationLoc:"",
              departureDateTime:0,
              arrivalDateTime:0,
              economySeatPrice:0,
              businessSeatPrice:0,
              totalEconomySeats:0,
              totalbusinessSeats:0,
              availableEconomySeats:0,
              availableBusinessSeats:0,
          });
      }
    const onUpdateRow = () =>
    {
        if(flightID >0){
            axios.put("http://localhost:8080/flight/update/"+flightID,{
                flightId:flightID,
                
                ...editObject,
            }).then((response) =>{
                if(response){
                    FetchData();
                    alert("updated");
                    onResetRowHandler();
                }
                });
            }
    }

    return(
        <>
        <h1 className="text-center">Flight form</h1>
            <form className="container" onSubmit={onFromSubmit}>
                <div className="col-md-5">
                     <label htmlFor="name" className="form-label"> Flight Name</label>
                    <input 
                            id="name"
                            className="form-control"
                            name="flightName" 
                            value={flightObject.flightName} 
                        onChange={onFlightObjectChangeHandler}
                        placeholder="Please Enter Your Name"
                    />
                </div>
                <div className="col-md-5">
                    <label htmlFor="sourcelocation"className="form-label">Source Location</label>
                    <input
                            id="sourcelocation"
                            className="form-control"
                            name="sourceLoc"
                            value={flightObject.sourceLoc}
                        onChange={onFlightObjectChangeHandler}
                        placeholder="Please Enter Source Location"
                    />
                </div>
                <div className="col-md-5">
                    <label htmlFor="destinationlocation" className="form-label">Destination Location</label>
                    <input 
                            id="destinationLocation"
                            className="form-control"
                            name="destinationLoc" 
                            value={flightObject.destinationLoc} 
                        onChange={onFlightObjectChangeHandler}
                        placeholder="Please Enter Destination Location"
                    />
                </div>
                <div className="col-md-5">
                    <label htmlFor="departuredatetime" className="form-label">Departure Date Time</label>
                    <input
                        id="departuredatetime"
                         className="form-control"
                         type="datetime-local"
                         name="departureDateTime"
                         value={flightObject.departureDateTime}
                        onChange={onFlightObjectChangeHandler}
                        
                    />
                </div>
                <div className="col-md-5">
                     <label htmlFor="arrivaldatetime" className="form-label">Arrival Date Time</label>
                    <input
                             id="arrivaldatetime"
                             className="form-control"
                             type="datetime-local"
                             name="arrivalDateTime"
                             value={flightObject.arrivalDateTime}
                             onChange={onFlightObjectChangeHandler} />
                </div>
                <div className="col-md-5">
                    <label htmlFor="economyseatprice" className="form-label">Economy Seat Price</label>
                    <input 
                            id="economyseatprice"
                             className="form-control"
                             name="economySeatPrice" 
                             value={flightObject.economySeatPrice} 
                        onChange={onFlightObjectChangeHandler}
                        
                    />
                </div>
                <div className="col-md-5">
                     <label htmlFor="businessseatprice" className="form-label">Business Seat Price</label>
                    <input 
                            id="businessseatprice"
                             className="form-control"
                             name="businessSeatPrice" 
                             value={flightObject.businessSeatPrice} 
                             onChange={onFlightObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                     <label htmlFor="totaleconomyseat" className="form-label">Total Economy Seats</label>
                    <input 
                            id="totaleconomyseat"
                           className="form-control"
                           name="totalEconomySeats" 
                           value={flightObject.totalEconomySeats} 
                           onChange={onFlightObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                      <label htmlFor="totalbusinessseats" className="form-label">Total Business Seats</label>
                    <input 
                            id="totalbusinessseats"
                            className="form-control"
                            name="totalbusinessSeats" 
                            value={flightObject.totalbusinessSeats}
                            onChange={onFlightObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                     <label htmlFor="availablebusinessseats" className="form-label">Available Business Seats</label>
                    <input 
                              id="availablebusinessseats"
                              className="form-control"
                              name="availableBusinessSeats" 
                              value={flightObject.availableBusinessSeats} 
                              onChange={onFlightObjectChangeHandler}/>
                </div>
                <div className="col-md-5">
                         <label htmlFor="availableeconomyseats" className="form-label">Available Economy Seats</label>
                            <input
                                  id="availableeconomyseats"
                                  className="form-control"
                                  name="availableEconomySeats"
                                  value={flightObject.availableEconomySeats} 
                                  onChange={onFlightObjectChangeHandler}/>
                </div>
                <br/>
                <div className="col-md-5">
                     <button type="submit" className="btn btn-success">{isEditMode ? "update" : "submit"}</button>
                    {isEditMode && <button>Rest:</button>}
                 </div>
            </form>
            <div className="text-center">
                <h1>Flight List</h1>
            </div>
            <table  className="table table-bordered border border-info">
                <thead>
                <tr className="table-dark">
                    <th>FlightID</th>
                    <th>FlightName</th>
                    <th>Flight Source</th>
                    <th>Flight Destination</th>
                    <th>DepartureDateTime</th>
                    <th>ArrivalDateTime</th>
                    <th>economySeatPrice</th>
                    <th>businessSeatPrice</th>
                    <th>totalEconomySeats</th>
                    <th>totalBusinessSeats</th>
                    <th>availableEconomySeats</th>
                    <th>availableBusinessSeats</th>
                    <th>Option</th>
                </tr>
                </thead>
                <tbody>
                    {flightList.map((flight)=>{
                        return(
                            <tr key={flight.flightId}>
                                <td>{flight.flightId}</td>
                                <td>
                                    {selectedFlightId === flight.flightId ?
                                     (<input 
                                     name="flightName" 
                                     value={editObject.flightName} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(flight.flightName)}</td>
                                <td>
                                    {selectedFlightId === flight.flightId ?
                                     (<input 
                                     name="sourceLoc" 
                                     value={editObject.sourceLoc} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(flight.sourceLoc)}
                                </td>
                                <td>
                                    {selectedFlightId === flight.flightId 
                                    ? (<input
                                     name="destinationLoc" 
                                     value={editObject.destinationLoc} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(flight.destinationLoc)}
                                </td>
                                <td>
                                    {selectedFlightId === flight.flightId
                                        ? (<input
                                            name="departureDateTime"
                                            value={editObject.departureDateTime}
                                            onChange={onEditObjectChangeHandler} />)
                                        : (flight.departureDateTime)}
                                </td>
                                <td>
                                    {selectedFlightId === flight.flightId
                                        ? (<input
                                            name="arrivalDateTime"
                                            value={editObject.arrivalDateTime}
                                            onChange={onEditObjectChangeHandler} />)
                                        : (flight.arrivalDateTime)}
                                </td>
                                <td>
                                    {selectedFlightId === flight.flightId ? 
                                    (<input name="economySeatPrice" 
                                    value={editObject.economySeatPrice} 
                                    onChange={onEditObjectChangeHandler}/>)
                                    : (flight.economySeatPrice)}</td>
                                <td>
                                    {selectedFlightId === flight.flightId ?
                                     (<input name="businessSeatPrice" 
                                     value={editObject.businessSeatPrice} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     :(flight.businessSeatPrice)}
                                </td>
                                <td>
                                    {selectedFlightId === flight.flightId ? 
                                    (<input 
                                    name="totalEconomySeats"
                                     value={editObject.totalEconomySeats} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     : (flight.totalEconomySeats)}</td>
                                <td>
                                    {selectedFlightId === flight.flightId ? 
                                    (<input 
                                    name="totalbusinessSeats" 
                                    value={editObject.totalbusinessSeats} 
                                    onChange={onEditObjectChangeHandler}/>)
                                    :(flight.totalbusinessSeats)}</td>
                                <td>
                                    {selectedFlightId === flight.flightId ?
                                     (<input 
                                     name="availableEconomySeats"
                                     value={editObject.availableEconomySeats} 
                                     onChange={onEditObjectChangeHandler}/>)
                                     : (flight.availableEconomySeats)}</td>
                                <td>
                                    {selectedFlightId === flight .flightId ?
                                 (<input 
                                 name="availableBusinessSeats" 
                                 value={editObject.availableBusinessSeats} 
                                 onChange={onEditObjectChangeHandler}/>):
                                 (flight.availableBusinessSeats)}
                                 </td>
                                 <td>{selectedFlightId === flight.flightId ? (<>
                                <button className="btn btn-info" onClick={onUpdateRow}>Update</button>
                                <button onClick={onResetRowHandler}> Reset</button>
                             </>) : (<>
                                <button className="btn btn-danger"
                                    onClick={() =>{
                                        onDeleteHandler(flight.flightId);
                                    }}
                                >Delete
                                </button>
                                <button className="btn-btn-secondary" onClick={()=>{ onEdit(flight)}}>Edit:</button>
                             </>)}
                             </td>
                            </tr>
                        );
                    })}
                    </tbody>
            </table>
        </>
    )
}
