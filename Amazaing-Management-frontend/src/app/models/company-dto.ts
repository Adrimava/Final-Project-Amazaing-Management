export class CompanyDTO {

    constructor (
        private _companyName: string,
        private _revenue: number,
        private _maintenance: number,
        private _employeesNumber: number,
        private _accidentRiskIndex: number,
        private _businessModelId: number,
        private _playerId: number
    ) { }
    
    public get playerId(): number {
        return this._playerId;
    }
    public set playerId(value: number) {
        this._playerId = value;
    }
    public get businessModelId(): number {
        return this._businessModelId;
    }
    public set businessModelId(value: number) {
        this._businessModelId = value;
    }
    public get accidentRiskIndex(): number {
        return this._accidentRiskIndex;
    }
    public set accidentRiskIndex(value: number) {
        this._accidentRiskIndex = value;
    }
    public get employeesNumber(): number {
        return this._employeesNumber;
    }
    public set employeesNumber(value: number) {
        this._employeesNumber = value;
    }
    public get maintenance(): number {
        return this._maintenance;
    }
    public set maintenance(value: number) {
        this._maintenance = value;
    }
    public get revenue(): number {
        return this._revenue;
    }
    public set revenue(value: number) {
        this._revenue = value;
    }
    public get companyName(): string {
        return this._companyName;
    }
    public set companyName(value: string) {
        this._companyName = value;
    }

}
