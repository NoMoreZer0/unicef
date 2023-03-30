import styles from './Rating.module.scss';
import {styled} from '@mui/material/styles';
import Rating, {IconContainerProps} from '@mui/material/Rating';
import SentimentVeryDissatisfiedIcon
  from '@mui/icons-material/SentimentVeryDissatisfied';
import SentimentDissatisfiedIcon
  from '@mui/icons-material/SentimentDissatisfied';
import SentimentSatisfiedIcon from '@mui/icons-material/SentimentSatisfied';
import SentimentSatisfiedAltIcon
  from '@mui/icons-material/SentimentSatisfiedAltOutlined';
import SentimentVerySatisfiedIcon
  from '@mui/icons-material/SentimentVerySatisfied';
import {ReactElement} from 'react';

const StyledRating = styled(Rating)(({theme}) => ({
  '& .MuiRating-iconEmpty .MuiSvgIcon-root': {
    color: theme.palette.action.disabled,
  },
  '& .MuiSvgIcon-root': {
    fontSize: '48px !important',
  },
}));

const customIcons: {
  [index: string]: {
    icon: ReactElement;
    label: string;
  };
} = {
  1: {
    icon: <SentimentVeryDissatisfiedIcon color="error"/>,
    label: 'Very Dissatisfied',
  },
  2: {
    icon: <SentimentDissatisfiedIcon color="error"/>,
    label: 'Dissatisfied',
  },
  3: {
    icon: <SentimentSatisfiedIcon color="warning"/>,
    label: 'Neutral',
  },
  4: {
    icon: <SentimentSatisfiedAltIcon color="success"/>,
    label: 'Satisfied',
  },
  5: {
    icon: <SentimentVerySatisfiedIcon color="success"/>,
    label: 'Very Satisfied',
  },
};

function IconContainer(props: IconContainerProps) {
  const {value, ...other} = props;
  return <span {...other}>{customIcons[value].icon}</span>;
}

export default function RadioGroupRating({value, onChange}) {
  return (
    <div className={styles.rating}>
      <StyledRating
        name="highlight-selected-only"
        defaultValue={value}
        onChange={onChange}
        IconContainerComponent={IconContainer}
        getLabelText={(value: number) => customIcons[value].label}
        highlightSelectedOnly
      />
    </div>

  );
}