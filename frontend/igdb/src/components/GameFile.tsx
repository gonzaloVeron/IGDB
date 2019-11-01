import React, {Component} from 'react';
import IGDBNavbar from './IGDBNavbar';

import styles from './File.module.css';

type GameProps = {
    location: {
        search: string;
    },
    match: {
        params: {
            id: string;
        },
    },
}

interface GameState {
    gameData: GameData
}

type GameData = {
    name: string
}

export default class GameFile extends Component<GameProps, GameState>{
    constructor(props: GameProps){
        super(props);
        console.log(props);
        this.state = {
            gameData: {
                name: '',
            }
        }
    }

    getName(): string {
        let search = this.getUrlParams();
        return search.get("name") || "";
      }
    
      getUrlParams(): URLSearchParams {
        if (!this.props.location.search) return new URLSearchParams();
        return new URLSearchParams(this.props.location.search);
      }

    componentDidMount(){
        //let name = this.props.match.params.id;
        let name = this.getName();
        this.setState({gameData: {name}});
    }

    fileTitle(): JSX.Element{
        return (
            <div className={styles.fileTitleBox}>
                <h1 className={styles.fileTitle}>{this.state.gameData.name}</h1>
            </div>
        );
    }

    fileContent(): JSX.Element{
        return (
            <div className={styles.fileTitle}>
                Soy contenido
            </div>
        );
    }

    render(){
        return(
            <div className={styles.navBodyHolder}>
                <IGDBNavbar />
                <div className={styles.fileBox}>
                    {this.fileTitle()}
                    {this.fileContent()}
                </div>
            </div>
            
        );
    }
}