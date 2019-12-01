import React from 'react';

export default class RAWGRating extends React.Component{
    
    determineColor(){
        let id = this.props.value.id
        if (id === 5){
            return "green";
        } else if (id === 4){
            return "blue"
        } else if (id === 3){
            return "orange"
        } else if (id === 1){
            return "red"
        }
    }
    
    render(){
        let color = this.determineColor()
        let marginRight = (Math.abs(this.props.value.percent - 50)).toString() + '%'
        return(
            <div style={{backgroundColor:color, color:"white", marginRight}}>
                <div style={{padding:"1% 1% 1% 1%"}}>
                    {this.props.value.title.toUpperCase()}: {this.props.value.count} ({this.props.value.percent}%)
                </div>
            </div>
        )
    }
}