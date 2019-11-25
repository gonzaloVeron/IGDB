import React from 'react';
import ReactStars from 'react-stars'
import {putReview} from '../../api/api'
import './GameFile.css'

export default class ReviewBox extends React.Component{
    constructor(props){
        super(props)
        console.log(props)
        this.state = {
            score: 0,
            content: "",
        }
        this.changeContent = this.changeContent.bind(this)
        this.changeScore = this.changeScore.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    changeScore(e){
        this.setState({score: e,});
    }

    changeContent(e){
        this.setState({content: e.target.value,});
    }

    onSubmit(e){
        if (this.checkData()){
            putReview(this.props.gameId, {userID: this.props.userId, score: this.state.score, description: this.state.content})
                .then((res)=>{
                    console.log("submitted")
                    this.props.onSubmit()
                })
                .catch((e)=>{
                    console.log("Error")
                    console.log(e)
                    this.setState({error: e})
                })
        }
    }

    checkData(){
        return this.state.score > 0
    }

    render(){
        return (
            <div className="card text-white bg-secondary mb-3" style={{ width: '510px'}}>
                <div className="row no-gutters">
                    <div className="col-md-8">
                        <div style={{marginLeft:"10%", paddingTop:'4%'}}>
                            <h5>Put a score!</h5>
                            <ReactStars count={5} edit={true} size={30} value={this.state.score} color2={'#ffd700'} half={false} onChange={this.changeScore} />
                        </div>
                        <div className="card-body">
                            <textarea value={this.state.content} name="Text1" cols="40" rows="5" className='textInput' onChange={this.changeContent}/>
                            <div>
                                <button className='btn' onClick={this.onSubmit}>Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}