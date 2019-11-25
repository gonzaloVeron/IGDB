import { Image, Col, Container } from 'react-bootstrap'
import ReactStars from 'react-stars'
import React from 'react';
import './card.css';
const thumbnail = require('../../images/thumbnail.png');

export default class ReviewCard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: {},
        };
    }

    render(){
        console.log(this.props)
        return(
            <div className="card text-white bg-secondary mb-3" style={{ width: '510px'}}>
                <div className="row no-gutters">
                    <div className="col-md-4">
                        <div>
                        <Container>
                            <Col xs={6} md={4}>
                                <Image style={{ width: '80px' }} src={thumbnail} roundedCircle />
                            </Col>
                            <div style={{marginRight:"2%", marginLeft:"24%", marginTop:"1%"}}>
                                {this.props.review.nameUser}
                            </div>
                        </Container>
                        </div>
                    </div>
                    <div className="col-md-8">
                        <div className="card-body">
                            <h6 className="card-title">{this.props.review.description}</h6> 
                        </div>
                        <div style={{marginLeft:"68%"}}>
                            <ReactStars count={5} edit={false} size={24} value={this.props.review.score} color2={'#ffd700'} half={false} />
                        </div>
                        {this.props.children}
                    </div>
                </div>
            </div>
        )
    }
}

