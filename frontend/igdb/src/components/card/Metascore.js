import React from 'react';

export default class Metascore extends React.Component{
    
    determineColor(){
        let id = this.props.metascore;
        if (id >= 75){
            return "green";
        } else if (id >= 50 && id < 75){
            return "orange"
        } else if (id < 50){
            return "orange"
        }
    }

    determineIndication(){
        let score = this.props.metascore;
        if (score >= 90){
            return "Universal acclaim";
        } else if (score >= 75 && score < 90){
            return "Generally favorable reviews"
        } else if (score >= 50 && score < 75){
            return "Mixed or average reviews"
        } else if (score >= 20 && score < 50){
            return "Generally unfavorable reviews"
        } else if (score >=0 && score < 20){
            return "Overwhelming dislike"
        }
    }
    
    render(){
        let color = this.determineColor();
        let indication = this.determineIndication();
        return(
            <div>
                <div>
                    {indication}
                </div>
                <div style={{
                    marginLeft:'16%',
                    backgroundColor:color,
                    color:"white",
                    width:"50px",
                    height:"50px",
                    padding:"9px 10px 10px 10px",
                    fontSize:'150%',
                    borderRadius:'10px'
                    }}>
                    {this.props.metascore}
                </div>
            </div>
        )
    }
}