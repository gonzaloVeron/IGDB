import ReactStars from 'react-stars'
import React from 'react';
import NavBar from '../navbar/NavBar';
import { getGame, deleteReview } from '../../api/api.js';
import {CollapsibleComponent, CollapsibleHead, CollapsibleContent} from 'react-collapsible-component'
import './GameFile.css';
import DevCard2 from '../card/DevCard2';
import ReviewCard from '../card/ReviewCard';
import ReviewBox from './ReviewBox';
const thumbnail = require('../../images/thumbnail.png');

export default class GameFile extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            gameData: {
                id: props.match.params.id,
                name: '',
                genre: '',
                platform: '',
                sinopsis: '',
                urlImage: '',
                videos: [],
                images: [],
                devs: [],
                studio: {
                    id:-999,
                    imageUrl: '',
                    name: '',
                },
                avScore: 0,
                reviews: [],
            }
        }
        console.log(props)
        console.log(this.state)
        this.refreshPage = this.refreshPage.bind(this);
        this.onDeleteReview = this.onDeleteReview.bind(this);
    }

    onDeleteReview(){
        deleteReview(this.state.gameData.id, {userId: localStorage.getItem("id")})
            .then((res)=>{
                this.componentDidMount()
            })
            .catch((e)=>{
                this.setState({error: e,})
            })
    }

    refreshPage(){
        this.componentDidMount()
    }
    
    componentDidMount(){
        let { id } = this.props.match.params
        getGame(id).then(result => {
            console.log(result)
            result.avScore = this.calculateAvScore(result.reviews)
            this.setState({ gameData : result });
        }).catch(e => {this.setState({ error: e.message })})
    }

    calculateAvScore(reviews){
        let sum = 0
        reviews.forEach(element => {
            sum += element.score
        });
        let tot = sum / reviews.length
        if (tot % 1 === 0){
            return (sum / reviews.length).toFixed(0)
        } else {
            return (sum / reviews.length).toFixed(2)
        }
    }

    fileTitle(){
        let thumb = this.state.gameData.urlImage || thumbnail
        return (
            <div className="card title-container">
                <div className="card-header header row">
                            <div className="column-image">
                                <img src={thumb} alt='' height="200" width="150"/>
                            </div>
                            <div className="column">
                                <h1 className="card-header title">{this.state.gameData.name}</h1>
                            </div>
                            <div className="column">
                                <div style={{marginLeft:"25%"}}>
                                    <h4>average score: {this.state.gameData.avScore}/5 </h4>
                                </div>
                                <div style={{marginLeft:"24%"}}>
                                    <ReactStars count={5} edit={false} size={75} value={this.state.gameData.avScore} color2={'#ffd700'} />
                                </div>
                            </div>
                    </div>
            </div>
        );
    }

    fileContent(){
        return (
            <div className="card file-content">
                <div className="file-content-element">
                    Sinopsis: {this.state.gameData.sinopsis}
                </div>
                <div className="file-content-element">
                    Genre: {this.state.gameData.genre}
                </div>
                <div className="file-content-element">
                    Platform: {this.state.gameData.platform}
                </div>
            </div>
        );
    }

    videos(){
        return (
            <div className="file-content-element" style={{marginRight: "2%"}}>
                <CollapsibleHead className="collapsible-head">Videos ({this.state.gameData.videos.length}) </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-6">
                            {this.renderVideoColumn(this.state.gameData.videos.slice(0, (this.state.gameData.videos.length / 2)))}
                        </div>
                        <div className="col-sm-6">
                            {this.renderVideoColumn(this.state.gameData.videos.slice((this.state.gameData.videos.length / 2), this.state.gameData.videos.length))}
                        </div>
                    </div>
                </CollapsibleContent>
            </div>
        )
    }

    renderVideoColumn(videos){
        return videos.map((link, i) => {return(<div key={i}><iframe title={"video" + i} width="420" height="315" src={link} allowFullScreen style={{margin:"1% 1% 1% 1%"}} /></div>)})
    }

    images(){
        return (
            <div style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
            <CollapsibleComponent className="file-content-element" >
                <CollapsibleHead className="collapsible-head">Images ({this.state.gameData.images.length}) </CollapsibleHead>
                <CollapsibleContent className="collapsible-content">
                    <div className="row">
                        <div className="col-sm-4">
                            {this.renderImageColumn(this.state.gameData.images.slice(0, (this.state.gameData.images.length / 3)))}
                        </div>
                        <div className="col-sm-4">
                            {this.renderImageColumn(this.state.gameData.images.slice((this.state.gameData.images.length / 3), (this.state.gameData.images.length / 3)*2))}
                        </div>
                        <div className="col-sm-4">
                            {this.renderImageColumn(this.state.gameData.images.slice((this.state.gameData.images.length / 3) * 2, this.state.gameData.images.length))}
                        </div>
                    </div>
                </CollapsibleContent>
            </CollapsibleComponent>
            </div>
        )
    }

    renderImageColumn(images){
        return images.map((link, i) => {return(<img key={i} alt="" width="300" height="220" src={link} style={{margin:"1% 1% 1% 1%"}} />)})
    }

    renderDevsColumn(){
        return this.state.gameData.devs.map((de, i) => {return <DevCard2 key={i} dev={de} history={this.props.history}/>} )
    }

    renderStudioImageColumn(){
        let thumb = this.state.gameData.studio.imageUrl || thumbnail
        return (
            <div>
                <h5 style={{color:"white", paddingLeft:"2%"}}>Studio:</h5>
                <img alt="" width="500" height="500" src={thumb} style={{margin:"1% 1% 1% 1%"}} />
            </div>
        )
    }

    creators(){
        return(
            <div className="card file-content" style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
                <div className="row" >
                    <div className="col-sm-6">
                        {this.renderStudioImageColumn()}
                    </div>
                    <div className="col-sm-4">
                        <div>
                            <h5 style={{color:"white", paddingLeft:"2%"}}>Developers:</h5>
                            {this.renderDevsColumn()}
                        </div>
                    </div>  
                </div>
            </div>
        )
    }

    renderReviewCards(){
        return(
            this.state.gameData.reviews.map((re, i) => {return <ReviewCard key={i} review={re}/>})
        )
    }

    reviews(){
        return(
            <div className="card file-content" style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
                <div className="row" >
                    <div style={{marginLeft:"42%"}}>
                        <h1 style={{color:"white"}}> User Reviews ({this.state.gameData.reviews.length}) </h1>
                    </div>
                </div>
                <div className="row" style={{marginLeft:"27%"}}>
                    {this.renderReviewCards()}
                </div>  
            </div>
        )
    }

    renderLeaveReview(){
        let id = localStorage.getItem("id");
        if (id){
            return this.renderUserReviewBox(id)
        } else{
            return (
                <div className="card file-content" style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
                    <div className="row" >
                        <div style={{marginLeft:"42%"}}>
                            <h1 style={{color:"white"}}> Login or Register to leave a review! </h1>
                        </div>
                    </div>
                </div>
            )
        }
    }

    renderUserReviewBox(id){
        let userReview = this.searchUserReview(id)
        if (userReview){
            return (
                <div className="card file-content" style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
                    <div className="row" >
                        <div style={{marginLeft:"40%"}}>
                            <h1 style={{color:"white"}}> Your review </h1>
                        </div>
                    </div>
                    <div className="row" style={{marginLeft:"27%"}}>
                        <ReviewCard review={userReview}>
                            <div style={{marginBottom:"2%", marginLeft:"70%"}}>
                                <button className='btn' onClick={this.onDeleteReview}>Delete</button>
                            </div>
                        </ReviewCard>
                    </div>  
                </div>
            )
        } else {
            return (
                <div className="card file-content" style={{marginRight:"2%", marginLeft:"2%", marginTop:"1%"}}>
                    <div className="row" >
                        <div style={{marginLeft:"40%"}}>
                            <h1 style={{color:"white"}}> Leave your review! </h1>
                        </div>
                    </div>
                    <div className="row" style={{marginLeft:"27%"}}>
                        <ReviewBox userId={id} gameId={this.state.gameData.id} onSubmit={this.refreshPage} />
                    </div>  
                </div>
            )
        }
    }

    searchUserReview(id){
        return this.state.gameData.reviews.find(e => e.userID == id)
    }

    render(){
        return(
            <div className="GameFile body-container">
                <NavBar/>
                <div className="container">
                    {this.fileTitle()}
                    {this.fileContent()}
                    {this.videos()}
                    {this.images()}
                    {this.creators()}
                    {this.renderLeaveReview()}
                    {this.reviews()}
                </div>
            </div>
        )
    }

}