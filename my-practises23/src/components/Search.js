
import {useState,useEffect} from 'react';
import axios from 'axios'
import '../styles/Search.css';
import { Rating } from 'react-simple-star-rating'

import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'
import L from 'leaflet'


const defaultCenter = [38.9072, -77.0369];
const defaultZoom = 8;
const disneyWorldLatLng = [28.3852, -81.5639];
const disneyLandLatLng = [33.8121, -117.9190];


function GetIcon(_iconSize,optionss) {
  return L.icon({
    iconUrl: require("../Static/Icons/"+optionss+".png"),
    iconSize: [_iconSize],
  });
}

export default function SearchBar(){
  
  


  
   const [selectvalue,setSelectValue]=useState("");
   const [searchtext,setSearchText]=useState("");
   const [suggest,setSuggest]=useState([]);
   const [maps, setMap] = useState(null);
   const [lat,setLat]=useState("");
   const [lon,setLon]=useState("");
   const [states,setStates]=useState(false);
   const [category,setCategory]=useState([]);
   const [himg,setImg]=useState(["himages/img1.jpg","himages/img2.jpg","himages/img3.jpg","himages/img4.jpg","himages/img5.jpg","himages/img6.jpg","himages/img7.jpg","himages/img8.jpeg","himages/img9.jpeg","himages/img10.jpeg"])
   const [eimg,setImg1]=useState(["eimages/eimg11.jpg","eimages/eimg12.png","eimages/eimg13.jpg","eimages/eimg14.jpg","eimages/eimg15.jpg","eimages/eimg16.jpg","eimages/eimg17.jpg","eimages/eimg18.jpg","eimages/eimg19.jpg","eimages/eimg20.jpg"])
   const [rimg,setImg2]=useState(["rimages/img11.jpg","rimages/img12.jpg","rimages/img13.jpg","rimages/img14.jpeg","rimages/img15.png","rimages/img16.jpg","rimages/img17.jpeg","rimages/img18.jpg","rimages/img19.jpg","rimages/img20.jpg"])
   var himg1=["himages/img1.jpg","himages/img2.jpg","himages/img3.jpg","himages/img4.jpg","himages/img5.jpg","himages/img6.jpg","himages/img7.jpg","himages/img8.jpeg","himages/img9.jpeg","himages/img10.jpeg"]
   var eimg1=["eimages/eimg11.jpg","eimages/eimg12.png","eimages/eimg13.jpg","eimages/eimg14.jpg","eimages/eimg15.jpg","eimages/eimg16.jpg","eimages/eimg17.jpg","eimages/eimg18.jpg","eimages/eimg19.jpg","eimages/eimg20.jpg"]
   var rimg1=["rimages/img11.jpg","rimages/img12.jpg","rimages/img13.jpg","rimages/img14.jpeg","rimages/img15.png","rimages/img16.jpg","rimages/img17.jpeg","rimages/img18.jpg","rimages/img19.jpg","rimages/img20.jpg"]

   const [rating, setRating] = useState(0) // initial rating value

   
   const handleRating = (rate: number) => {
     setRating(rate)
    
   }



   const getSuggestion=(e)=>{
    let addr=e.target.value;

  

    if(e.target.value==""){
        setSearchText("");
        setSuggest([]);
    }
    else {
        setSearchText(addr);

    axios.get("https://api.locationiq.com/v1/autocomplete.php?key=pk.011c8625a3a6786a8818a32ed6530781&q="+addr+"&limit=3")
    .then((response)=>{
        console.log(response.data)
        setSuggest(response.data);

    })
   .catch((error)=>{

    console.log(error);
   });

    }
}

const displayLocation=()=>{

    
    axios.get("https://us1.locationiq.com/v1/search.php?key=pk.011c8625a3a6786a8818a32ed6530781&q="+searchtext+"&format=json")
     .then((response)=>{
       console.log(response.data[0]["lat"]);
       console.log(response.data[0]["lon"]);
       setLat(response.data[0]["lat"]);
       setLon(response.data[0]["lon"]);
       setSuggest([])
       console.log("l"+lat+" "+"lon"+lon);
       setStates(true);

       maps.flyTo([response.data[0]["lat"],response.data[0]["lon"]], 14, {
        duration: 2
      })
     

     })
     .catch((error)=>{
       console.log("error");

     })
   
  }

  useEffect(()=>{

    if(states){
        if(selectvalue=="Hotels"){
            var URL="http://localhost:8080/places/getHotel";
            console.log("hotels")
         }
         else if(selectvalue=="EntertainmentPlaces"){
            var URL="http://localhost:8080/places/getEntertain";
            console.log("entertain")
         }
         else if(selectvalue=="Restaurant") {
            var URL="http://localhost:8080/places/getRestaurant";
            console.log("restaurant")
        
         }
         axios.get(URL+"/"+lat+"/"+lon)
         .then((response)=>{
    
               console.log(response);    
               setCategory(response.data);
              
         })
    
         .catch((error)=>{
             console.log(error);

         })
    
        
    }
  })

return (
    <>

        <div class="container">
        <div class="row">
        <div class="col-lg-2 sm-2" ><label style={{marginTop: '50px'}}><h4>Category</h4></label></div>
        <div class="col-lg-3 sm-4" >
        <select class="form-select" style={{marginTop : "50px",textAlign:"center"}} aria-label="Default select example"  onChange={ (e)=> setSelectValue(e.target.value)}>
        <option selected>Select Category</option>
        <option value="Hotels">Hotels</option>
        <option value="EntertainmentPlaces">EntertainmentPlaces</option>
        <option value="Restaurant">Restaurant</option>
        </select>
        </div>
        </div>

        <br/>
        <div class="row ">
        <div class="col-2">
        <label class="col-form-label"><h4>Address</h4></label></div>
      
        <div class="col-7">
        <div class="input-group">
        <input type="text" class="form-control" id="inputAddress" value={searchtext} onChange={(e)=>getSuggestion(e)}/>
        <div class="input-group-append">
        <button type="button" class="btn btn-outline-secondary" onClick={()=> {setSuggest([]); setSearchText("")}}><i class="bi bi-x"></i></button>
        </div>
        </div>
        </div>
        <div class="col-2">
        <button type="button" class="btn btn-warning" onClick={displayLocation}> Search Places  </button>
        </div>

          
        
        </div>
      <div class="row ">
      <div class="col-2"></div>
      <div class="col">
      
      <div class="list-group" style={{ position: 'absolute',zIndex: 3}}>
      {
          

          suggest.map((value,index)=>{

             
            
              return   <button type="button" key={index} style={{width:'600px'}} onClick={()=> {setSearchText(value.display_name); setSuggest([])}} class="list-group-item list-group-item-action">{value["display_name"]}</button>
            
          })
      }
      </div>
      
      </div>
      
      </div>
      <br/>
      <div class="row">
      <div class="col" style={{position:'relative', zIndex: -1}}>
      

        <MapContainer whenCreated={setMap} center={defaultCenter}  zoom={13} scrollWheelZoom={false}>
            <TileLayer
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            <Marker position={[lat,lon]}  >
            <Popup>
            A pretty CSS3 popup. <br /> Easily customizable.
            </Popup>
        </Marker>
        {
          
            category.map((value,index)=>{
              if (selectvalue=="Hotels"){
              return  (<Marker position={[value.latitude,value.longitude]} icon={GetIcon(50,"hotel")}>
              <Popup>
              A pretty CSS3 popup. <br /> Easily customizable.
              </Popup>
                     </Marker>)
              }
              else if(selectvalue=="Restaurant"){
                return  (<Marker position={[value.latitude,value.longitude]} icon={GetIcon(50,"cafe")}>
                  <Popup>
                  A pretty CSS3 popup. <br /> Easily customizable.
                  </Popup>
                         </Marker>)

              }
              else if(selectvalue=="EntertainmentPlaces"){
                return  (<Marker position={[value.latitude,value.longitude]} icon={GetIcon(50,"popcorn")} >
                  <Popup>
                  A pretty CSS3 popup. <br /> Easily customizable.
                  </Popup>
                         </Marker>)

              }
            })
          

        }
        </MapContainer>
        </div>
        </div>
        </div>
        <br/>
        <div class="container">
        <div class="row">
        {
            
            category.map((value)=>{

              if(selectvalue=="Hotels"){
              return (
                 
      
    
                  <div class="col">
               
                <div class="card" style={{width: '20rem',height : '22rem',marginTop : "10px"}}>
                <img class="card-img-top" src={himg1[Math.floor(Math.random() * himg1.length)]} alt="Card image cap" width="200px" height="200px"/>
                <div class="card-body">
                  <h5 class="card-title">{value.name}</h5>
                  <Rating onClick={handleRating} ratingValue={rating} /* Available Props */ />
                  <br/>
                  <a href="#" class="btn btn-primary">Distance {value.distance}</a>
                </div>
              </div>
              </div>
              )
              }
              else if(selectvalue=="Restaurant"){
                return (
                 
      
             
                  <div class="col">
               
                <div class="card" style={{width: '20rem',height : '22rem',marginTop : "10px"}}>
                <img class="card-img-top" src={rimg1[Math.floor(Math.random() * rimg1.length)]} alt="Card image cap" width="200px" height="200px" />
                <div class="card-body">
                  <h5 class="card-title">{value.name}</h5>
                  <Rating onClick={handleRating} ratingValue={rating} /* Available Props */ />
                  <br/>
                  <a href="#" class="btn btn-primary">Distance {value.distance}</a>
                </div>
              </div>
              </div>
              )

              }

              else if(selectvalue=="EntertainmentPlaces"){
                return (
                 
      
    
                  <div class="col">
               
                <div class="card" style={{width: '20rem',height : '22rem',marginTop : "10px"}}>
                <img class="card-img-top" src={eimg1[Math.floor(Math.random() * eimg1.length)]} alt="Card image cap"  width="200px" height="200px" />
                <div class="card-body">
                  <h5 class="card-title">{value.name}</h5>
                  <Rating onClick={handleRating} ratingValue={rating} /* Available Props */ />
                  <br/>
                  <a href="#" class="btn btn-primary">Distance {value.distance}</a>
                </div>
              </div>
              </div>
              )

              }
            })
          
        }
        </div>
        </div>
       <br/>
      
    
    </>
)







}