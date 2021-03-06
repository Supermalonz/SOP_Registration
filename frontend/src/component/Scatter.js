import React, {useState,useEffect} from 'react'
import {Line} from 'react-chartjs-2';
import { makeStyles,withStyles } from '@material-ui/core/styles';
const useStyle = makeStyles(theme => ({
    root:{
        width:'100%'
    }
}));
export default function LinePlot({props}){
    let classes = useStyle()
    const [data, setdata] = useState({
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [
          {
            label: 'My First dataset',
            fill: false,
            lineTension: 0.1,
            backgroundColor: 'rgba(75,192,192,0.4)',
            borderColor: 'rgba(75,192,192,1)',
            borderCapStyle: 'butt',
            borderDash: [],
            borderDashOffset: 0.0,
            borderJoinStyle: 'miter',
            pointBorderColor: 'rgba(75,192,192,1)',
            pointBackgroundColor: '#fff',
            pointBorderWidth: 1,
            pointHoverRadius: 5,
            pointHoverBackgroundColor: 'rgba(75,192,192,1)',
            pointHoverBorderColor: 'rgba(220,220,220,1)',
            pointHoverBorderWidth: 2,
            pointRadius: 1,
            pointHitRadius: 10,
            data: [0, 1, 0, 1, 1, 1, 0]
          }
        ]
      })
    return(
        <div className={classes.root}>
        <h2>Scatter Example</h2>
        <Line 
            width={1000}
            height={500}
            data={data}
            options={{ 
                // maintainAspectRatio: false,
                responsive: true,
             }} />
        </div>
    );
}